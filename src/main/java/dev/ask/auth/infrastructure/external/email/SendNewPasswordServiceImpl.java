package dev.ask.auth.infrastructure.external.email;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import dev.ask.auth.domain.service.email.SendNewPasswordService;
import dev.ask.auth.infrastructure.external.utils.SendEmail;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class SendNewPasswordServiceImpl implements SendNewPasswordService {

    private final SendEmail sendEmail;
    private final @Qualifier("customTemplateEngine") SpringTemplateEngine templateEngine;

    @Override
    public Mono<Void> sendNewPassword(String email, String newPassword) {
        return Mono.fromRunnable(() -> {
            Context context = new Context();
            context.setVariable("password", newPassword);
            String html = templateEngine.process("reset-password-random", context);

            sendEmail.sendEmail(email, "Tu nueva contraseña", html);
        });
    }
}