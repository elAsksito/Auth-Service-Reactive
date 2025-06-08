package dev.ask.auth.application.service.user;

import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dev.ask.auth.application.payload.request.RegisterRequest;
import dev.ask.auth.domain.model.User;
import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.audit_log.CreateAuditLogService;
import dev.ask.auth.domain.service.email.SendWelcomeEmailService;
import dev.ask.auth.domain.service.password_history.SavePasswordHistoryService;
import dev.ask.auth.domain.service.user.RegisterUserService;
import dev.ask.auth.domain.vo.Email;
import dev.ask.auth.domain.vo.Password;
import dev.ask.auth.infrastructure.persistence.mapper.UserMapper;
import dev.ask.auth.shared.enums.Action;
import dev.ask.auth.shared.exception.auth_exceptions.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RegisterUserServiceImpl implements RegisterUserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final SavePasswordHistoryService savePasswordHistoryService;
    private final CreateAuditLogService createAuditLogService;
    private final SendWelcomeEmailService sendWelcomeEmailService;

    @Override
    public Mono<User> createUserWithEmailAndPassword(RegisterRequest request, String ipAddress, String userAgent) {
        Email email = new Email(request.getEmail());
        Password password = new Password(request.getPassword());
        String encodedPassword = passwordEncoder.encode(password.value());

        return userRepository.existsByEmail(email.value())
                .flatMap(exists -> {
                    if (exists) {
                        return createAuditLogService.save(
                                null,
                                Action.REGISTER_FAILURE.toString(),
                                ipAddress,
                                userAgent,
                                Map.of(
                                        "email", email.value(),
                                        "reason", "Email already in use",
                                        "ipAddress", ipAddress,
                                        "userAgent", userAgent))
                                .then(Mono.error(new UserAlreadyExistException()));
                    }
                    return userRepository.createUser(email.value(), encodedPassword)
                            .flatMap(userDocument -> Mono.when(
                                    savePasswordHistoryService.savePasswordHistory(userDocument.getId(),
                                            encodedPassword),
                                    createAuditLogService.save(
                                            userDocument.getId(),
                                            Action.REGISTER.toString(),
                                            ipAddress,
                                            userAgent,
                                            Map.of(
                                                    "email", email.value(),
                                                    "action", Action.REGISTER.toString(),
                                                    "ipAddress", ipAddress,
                                                    "userAgent", userAgent)),
                                                    sendWelcomeEmailService.sendWelcomeEmail(email.value()))
                                    .thenReturn(UserMapper.toDomain(userDocument)))
                            .switchIfEmpty(
                                    createAuditLogService.save(
                                            null,
                                            Action.REGISTER_FAILURE.toString(),
                                            ipAddress,
                                            userAgent,
                                            Map.of(
                                                    "email", email.value(),
                                                    "reason", "User creation returned empty",
                                                    "ipAddress", ipAddress,
                                                    "userAgent", userAgent))
                                            .then(Mono.error(new IllegalStateException("User creation failed"))));
                });
    }
}