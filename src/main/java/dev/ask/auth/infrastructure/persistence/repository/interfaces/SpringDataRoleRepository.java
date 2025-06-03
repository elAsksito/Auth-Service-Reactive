package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.RoleDocument;
import reactor.core.publisher.Mono;

public interface SpringDataRoleRepository extends ReactiveMongoRepository<RoleDocument, String> {
    Mono<RoleDocument> findByName(String name);
    Mono<Boolean> existsByName(String name);
}