package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.TokenDocument;
import reactor.core.publisher.Mono;

public interface SpringDataTokenRepository extends ReactiveMongoRepository<TokenDocument, String> {
    Mono<TokenDocument> findByTokenHash(byte[] tokenHash);
}