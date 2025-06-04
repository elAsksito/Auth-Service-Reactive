package dev.ask.auth.infrastructure.persistence.repository.implementation;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.RoleRepository;
import dev.ask.auth.infrastructure.persistence.document.RoleDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataRoleRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

    private final SpringDataRoleRepository repository;

    @Override
    public Mono<RoleDocument> findByName(String name) {
        return repository.findByName(name);
    }
}