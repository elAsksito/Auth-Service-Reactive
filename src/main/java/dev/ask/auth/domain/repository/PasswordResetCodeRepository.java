package dev.ask.auth.domain.repository;

import java.time.Duration;

import reactor.core.publisher.Mono;

public interface PasswordResetCodeRepository  {
    Mono<Void> saveResetCode(String email, String code, Duration duration);
    Mono<Boolean> verifyCode(String email, String code);
    Mono<Void> deleteCode(String email);
}