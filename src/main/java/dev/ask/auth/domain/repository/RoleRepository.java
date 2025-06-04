package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.RoleDocument;
import reactor.core.publisher.Mono;

public interface RoleRepository {
    Mono<RoleDocument> findByName(String name);
}