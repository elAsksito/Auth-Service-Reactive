package dev.ask.auth.application.service.role;

import dev.ask.auth.domain.model.Role;
import dev.ask.auth.domain.repository.RoleRepository;
import dev.ask.auth.domain.service.role.FindRoleByNameService;
import dev.ask.auth.infrastructure.persistence.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindRoleByNameServiceImpl implements FindRoleByNameService {

    private final RoleRepository roleRepository;

    @Override
    public Mono<Role> findByName(String name) {
        return roleRepository.findByName(name).map(RoleMapper::toDomain);
    }
}