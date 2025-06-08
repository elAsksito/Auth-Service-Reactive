package dev.ask.auth.application.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;

import dev.ask.auth.application.utils.NewPassword;
import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.email.SendNewPasswordService;
import dev.ask.auth.domain.service.password_history.SavePasswordHistoryService;
import dev.ask.auth.domain.service.user.ResetPasswordService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ResetPasswordServiceImpl implements ResetPasswordService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SendNewPasswordService sendNewPasswordService;
    private final SavePasswordHistoryService savePasswordHistoryService;

    @Override
    public Mono<Void> resetAndSendNewPassword(String email) {
        return userRepository.findByEmail(email)
                .flatMap(user -> {
                    String newPassword = NewPassword.generateSecurePassword();
                    String passwordHash = passwordEncoder.encode(newPassword);
                    user.setPassword(passwordHash);
                    return userRepository.updateUser(user.getId(), user)
                            .then(savePasswordHistoryService.savePasswordHistory(user.getId(), passwordHash))
                            .then(sendNewPasswordService.sendNewPassword(email, newPassword));
                });
    }
}