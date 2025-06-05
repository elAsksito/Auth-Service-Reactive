package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.role.FindRoleByNameServiceImpl;
import dev.ask.auth.domain.repository.RoleRepository;
import dev.ask.auth.domain.service.role.FindRoleByNameService;

@Configuration
public class RoleServiceConfig {
    @Bean
    FindRoleByNameService findRoleByNameService(RoleRepository roleRepository) {
        return new FindRoleByNameServiceImpl(roleRepository);
    }
}