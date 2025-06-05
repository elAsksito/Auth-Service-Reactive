package dev.ask.auth.domain.service.password_history;

import reactor.core.publisher.Mono;

public interface IsPasswordUsedService {
    Mono<Boolean> isPasswordUsed(String userId, String passwordHash);
}