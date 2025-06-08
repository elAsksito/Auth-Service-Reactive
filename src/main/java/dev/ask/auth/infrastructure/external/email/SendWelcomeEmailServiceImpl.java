package dev.ask.auth.infrastructure.external.email;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import dev.ask.auth.domain.service.email.SendWelcomeEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class SendWelcomeEmailServiceImpl implements SendWelcomeEmailService {

    private final JavaMailSender mailSender;
    private final @Qualifier("customTemplateEngine") SpringTemplateEngine templateEngine;

    @Override
    public Mono<Void> sendWelcomeEmail(String to) {
        return Mono.fromRunnable(() -> {
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                helper.setTo(to);
                helper.setSubject("¡Bienvenido a AuthService!");
                helper.setFrom("provincianodemierda@gmail.com");

                Context context = new Context();
                context.setVariable("subject", "¡Bienvenido a AuthService!");
                context.setVariable("title", "¡Bienvenido a AuthService! 👋");
                context.setVariable("message",
                        "Gracias por unirte a los usuarios de AuthService. Estamos felices de tenerte con nosotros.");

                String html = templateEngine.process("welcome-email", context);

                helper.setText(html, true);
                mailSender.send(message);

            } catch (MessagingException e) {
                throw new RuntimeException("Error al enviar el correo de bienvenida", e);
            }
        });
    }
}