package dev.ask.auth.domain.service.email;

import reactor.core.publisher.Mono;

public interface SendWelcomeEmailService {
    Mono<Void> sendWelcomeEmail(String to);
}