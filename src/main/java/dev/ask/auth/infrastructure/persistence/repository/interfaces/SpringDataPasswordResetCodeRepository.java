package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import dev.ask.auth.infrastructure.persistence.document.PasswordResetCodeDocument;
import reactor.core.publisher.Mono;

public interface SpringDataPasswordResetCodeRepository
        extends ReactiveCrudRepository<PasswordResetCodeDocument, String> {
    Mono<PasswordResetCodeDocument> findById(String email);

    Mono<Void> deleteById(String email);
}