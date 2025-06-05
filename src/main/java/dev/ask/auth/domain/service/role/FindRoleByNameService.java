package dev.ask.auth.domain.service.role;

import dev.ask.auth.domain.model.Role;
import reactor.core.publisher.Mono;

public interface FindRoleByNameService {
    Mono<Role> findByName(String name);
}