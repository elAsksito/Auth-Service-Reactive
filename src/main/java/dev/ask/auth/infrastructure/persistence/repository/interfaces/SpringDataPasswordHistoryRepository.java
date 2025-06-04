package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.PasswordHistoryDocument;
import reactor.core.publisher.Mono;

public interface SpringDataPasswordHistoryRepository extends ReactiveMongoRepository<PasswordHistoryDocument, String> {
    Mono<PasswordHistoryDocument> findByUserIdAndPasswordHash(String userId, String passwordHash);
}