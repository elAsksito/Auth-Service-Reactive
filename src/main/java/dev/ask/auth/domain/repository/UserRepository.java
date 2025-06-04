package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.UserDocument;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<UserDocument> createUser(String email, String password);
    Mono<UserDocument> loginUser(String email, String password);
    Mono<UserDocument> findById(String userId);
    Mono<UserDocument> updateUser(String userId, UserDocument userDocument);
}