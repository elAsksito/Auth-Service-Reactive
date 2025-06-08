package dev.ask.auth.domain.service.user;

import reactor.core.publisher.Mono;

public interface ResetPasswordService {
    Mono<Void> resetAndSendNewPassword(String email);
}