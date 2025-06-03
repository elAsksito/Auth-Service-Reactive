package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.UserDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SpringDataUserRepository extends ReactiveMongoRepository<UserDocument, String> {
    Mono<UserDocument> findByEmail(String email);
    Mono<Boolean> existsByEmail(String email);
    Flux<UserDocument> findByRole(String role);
}