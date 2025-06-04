package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.UserDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<UserDocument> findByEmail(String email);
    Mono<Boolean> existsByEmail(String email);
    Flux<UserDocument> findByRole(String role);
    Mono<UserDocument> save(UserDocument user);
    Mono<UserDocument> findById(String id);
    Mono<UserDocument> update(String userId,UserDocument user);
}
