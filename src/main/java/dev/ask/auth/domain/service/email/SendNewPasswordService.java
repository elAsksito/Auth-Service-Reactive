package dev.ask.auth.domain.service.email;

import reactor.core.publisher.Mono;

public interface SendNewPasswordService {
    Mono<Void> sendNewPassword(String email, String newPassword);
}