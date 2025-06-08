package dev.ask.auth.infrastructure.external.email;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import dev.ask.auth.domain.service.email.SendResetCodeService;
import dev.ask.auth.infrastructure.external.utils.SendEmail;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class SendResetCodeServiceImpl implements SendResetCodeService {

    private final SendEmail sendEmail;
    private final @Qualifier("customTemplateEngine") SpringTemplateEngine templateEngine;

    @Override
    public Mono<Void> sendResetCode(String email, String code) {
        return Mono.fromRunnable(() -> {
            Context context = new Context();
            context.setVariable("code", code);
            String html = templateEngine.process("reset-password-code", context);

            sendEmail.sendEmail(email, "Código para restablecer contraseña", html);
        });
    }
}