package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.SessionDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SpringDataSessionRepository extends ReactiveMongoRepository<SessionDocument, String> {
    Flux<SessionDocument> findByUserIdAndIsRevokedFalse(String userId);
    Mono<SessionDocument> findByIdAndIsRevokedFalse(String id);
    Mono<SessionDocument> findByUserId(String userId);
}