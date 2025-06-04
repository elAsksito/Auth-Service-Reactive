package dev.ask.auth.infrastructure.persistence.mapper;

import dev.ask.auth.domain.model.Role;
import dev.ask.auth.infrastructure.persistence.document.RoleDocument;

public class RoleMapper {
    public static RoleDocument toDocument(Role domain) {
        if (domain == null)
            return null;

        return RoleDocument.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .build();
    }

    public static Role toDomain(RoleDocument document) {
        if (document == null)
            return null;

        return Role.builder()
                .id(document.getId())
                .name(document.getName())
                .description(document.getDescription())
                .build();
    }
}
