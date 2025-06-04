package dev.ask.auth.infrastructure.persistence.mapper;

import dev.ask.auth.domain.model.PasswordHistory;
import dev.ask.auth.infrastructure.persistence.document.PasswordHistoryDocument;

public class PasswordHistoryMapper {
    public static PasswordHistoryDocument toDocument(PasswordHistory domain) {
        if (domain == null)
            return null;

        return PasswordHistoryDocument.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .passwordHash(domain.getPasswordHash())
                .changedAt(domain.getChangedAt())
                .build();
    }

    public static PasswordHistory toDomain(PasswordHistoryDocument document) {
        if (document == null)
            return null;

        return PasswordHistory.builder()
                .id(document.getId())
                .userId(document.getUserId())
                .passwordHash(document.getPasswordHash())
                .changedAt(document.getChangedAt())
                .build();
    }
}