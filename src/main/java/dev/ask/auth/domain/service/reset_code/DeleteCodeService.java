package dev.ask.auth.domain.service.reset_code;

import reactor.core.publisher.Mono;

public interface DeleteCodeService {
    Mono<Void> deleteCode(String email);
}