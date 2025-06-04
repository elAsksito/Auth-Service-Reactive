package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.SessionDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SpringDataSessionRepository extends ReactiveMongoRepository<SessionDocument, String> {
    Mono<SessionDocument> findByUserIdAndIsRevokedFalse(String userId);
    Mono<SessionDocument> findByUserIdAndSessionTokenHashAndIsRevokedFalse(String userId, byte[] sessionTokenHash);
    Flux<SessionDocument> findAllByUserIdAndIsRevokedFalse(String userId);
}