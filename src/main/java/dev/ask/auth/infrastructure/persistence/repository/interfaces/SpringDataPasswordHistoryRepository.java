package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.PasswordHistoryDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SpringDataPasswordHistoryRepository extends ReactiveMongoRepository<PasswordHistoryDocument, String> {
    Flux<PasswordHistoryDocument> findByUserIdOrderByChangedAtDesc(String userId);
    Mono<Boolean> existsByUserIdAndPasswordHash(String userId, String passwordHash);
}