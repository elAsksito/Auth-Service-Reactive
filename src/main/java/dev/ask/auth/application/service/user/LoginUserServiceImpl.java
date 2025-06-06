package dev.ask.auth.application.service.user;

import dev.ask.auth.application.payload.request.LoginRequest;
import dev.ask.auth.application.payload.response.LoginResponse;
import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.audit_log.CreateAuditLogService;
import dev.ask.auth.domain.service.failed_login_attempts_ip.CheckAndUnblockIfExpiredService;
import dev.ask.auth.domain.service.failed_login_attempts_ip.HandleFailedLoginService;
import dev.ask.auth.domain.service.ip_block.IsIpBlockedService;
import dev.ask.auth.domain.service.login_event.FailedLoginEventService;
import dev.ask.auth.domain.service.login_event.SuccessLoginEventService;
import dev.ask.auth.domain.service.session.GetExistingSessionService;
import dev.ask.auth.domain.service.session.RevokeSessionService;
import dev.ask.auth.domain.service.token.ExistsActiveTokenForDeviceService;
import dev.ask.auth.domain.service.token.GenerateAccessTokenService;
import dev.ask.auth.domain.service.token.SaveTokenService;
import dev.ask.auth.domain.service.user.LoginUserService;
import dev.ask.auth.domain.vo.Email;
import dev.ask.auth.domain.vo.Password;
import dev.ask.auth.shared.enums.Action;
import dev.ask.auth.shared.exception.auth_exceptions.InvalidCredentialsException;
import dev.ask.auth.shared.exception.auth_exceptions.IpBlockedException;
import dev.ask.auth.shared.exception.auth_exceptions.TooManyLoginAttemptsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Map;

@RequiredArgsConstructor
public class LoginUserServiceImpl implements LoginUserService {

    private final UserRepository userRepository;
    private final SaveTokenService saveTokenService;
    private final ExistsActiveTokenForDeviceService existsActiveTokenForDeviceService;
    private final RevokeSessionService revokeSessionService;
    private final BCryptPasswordEncoder passwordEncoder;

    private final CreateAuditLogService createAuditLogService;
    private final HandleFailedLoginService handleFailedLoginService;
    private final SuccessLoginEventService successLoginEventService;
    private final FailedLoginEventService failedLoginEventService;
    private final IsIpBlockedService isIpBlockedService;
    private final CheckAndUnblockIfExpiredService checkAndUnblockIpService;
    private final GetExistingSessionService getExistingSessionService;
    private final GenerateAccessTokenService generateAccessTokenService;

    @Override
    public Mono<LoginResponse> loginUserWithEmailAndPassword(LoginRequest request, String ipAddress, String userAgent) {
        Email email = new Email(request.getEmail());
        Password password = new Password(request.getPassword());

        return checkAndUnblockIpService.checkAndUnblockIfExpired(ipAddress)
            .then(isIpBlockedService.isIpBlocked(ipAddress))
            .flatMap(isBlocked -> {
                if (isBlocked) {
                    return Mono.error(new IpBlockedException());
                }

                return userRepository.loginUser(email.value(), password.value())
                    .switchIfEmpty(Mono.error(new InvalidCredentialsException()))
                    .flatMap(user -> {
                        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());

                        if (!matches) {
                            return handleFailedLoginService.handleFailedLogin(ipAddress)
                                .flatMap(failed -> {
                                    if (failed.getBlockedUntil() != null &&
                                        failed.getBlockedUntil().isAfter(Instant.now())) {
                                        return Mono.error(new TooManyLoginAttemptsException());
                                    }

                                    return Mono.zip(
                                            createAuditLogService.save(
                                                    user.getId(),
                                                    Action.LOGIN_FAILURE.toString(),
                                                    ipAddress,
                                                    userAgent,
                                                    Map.of(
                                                            "email", email.value(),
                                                            "action", Action.LOGIN_FAILURE.toString(),
                                                            "ipAddress", ipAddress,
                                                            "userAgent", userAgent)),
                                            failedLoginEventService.failedLoginEvent(
                                                    user.getId(), ipAddress, userAgent, "",
                                                    Action.LOGIN_FAILURE.toString()))
                                        .then(Mono.error(new InvalidCredentialsException()));
                                });
                        }

                        return existsActiveTokenForDeviceService.existsActiveTokenForDevice(user.getId(), ipAddress, userAgent)
                            .flatMap(exists -> {
                                if (!exists) {
                                    return revokeSessionService
                                            .revokeSession(user.getId(), ipAddress, userAgent)
                                            .then(saveTokenService.saveToken(user.getId(), ipAddress, userAgent));
                                } else {
                                    return Mono.empty();
                                }
                            })
                            .then(getExistingSessionService.getExistingSession(user.getId(), ipAddress, userAgent))
                            .flatMap(session -> generateAccessTokenService.generateToken(user.getId(), session.getId(), ipAddress, userAgent))
                            .flatMap(accessToken -> {
                                return Mono.zip(
                                        createAuditLogService.save(
                                                user.getId(),
                                                Action.LOGIN_SUCCESS.toString(),
                                                ipAddress,
                                                userAgent,
                                                Map.of(
                                                        "email", email.value(),
                                                        "action", Action.LOGIN_SUCCESS.toString(),
                                                        "ipAddress", ipAddress,
                                                        "userAgent", userAgent)),
                                        successLoginEventService.successLoginEvent(
                                                user.getId(), ipAddress, userAgent, "")
                                ).thenReturn(LoginResponse.builder()
                                        .accessToken(accessToken)
                                        .build());
                            });
                    });
            });
    }
}
