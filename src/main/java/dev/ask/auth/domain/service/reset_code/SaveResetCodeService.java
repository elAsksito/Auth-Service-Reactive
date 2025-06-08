package dev.ask.auth.domain.service.reset_code;

import java.time.Duration;

import reactor.core.publisher.Mono;

public interface SaveResetCodeService {
    Mono<Void> saveResetCode(String email, String code, Duration duration);
}