package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.PasswordHistoryDocument;
import reactor.core.publisher.Mono;

public interface PasswordHistoryRepository {
    Mono<PasswordHistoryDocument> savePasswordHistory(String userId, String passwordHash);
    Mono<Boolean> isPasswordUsed(String userId, String passwordHash);
}