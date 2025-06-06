package dev.ask.auth.domain.service.user;

import reactor.core.publisher.Mono;

public interface ExistsByEmailService {
    Mono<Boolean> existsByEmail(String email);
}