package dev.ask.auth.domain.service.email;

import reactor.core.publisher.Mono;

public interface SendResetCodeService {
    Mono<Void> sendResetCode(String email, String code);
}