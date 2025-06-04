package dev.ask.auth.infrastructure.persistence.mapper;

import dev.ask.auth.domain.model.OneTimeToken;
import dev.ask.auth.infrastructure.persistence.document.OneTimeTokenDocument;

public class OneTimeTokenMapper {
    public static OneTimeTokenDocument toDocument(OneTimeToken domain) {
        if (domain == null)
            return null;

        return OneTimeTokenDocument.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .tokenHash(domain.getTokenHash())
                .tokenType(domain.getTokenType())
                .isUsed(domain.isUsed())
                .usedAt(domain.getUsedAt())
                .expiresAt(domain.getExpiresAt())
                .createdAt(domain.getCreatedAt())
                .build();
    }

    public static OneTimeToken toDomain(OneTimeTokenDocument document) {
        if (document == null)
            return null;

        return OneTimeToken.builder()
                .id(document.getId())
                .userId(document.getUserId())
                .tokenHash(document.getTokenHash())
                .tokenType(document.getTokenType())
                .isUsed(document.isUsed())
                .usedAt(document.getUsedAt())
                .expiresAt(document.getExpiresAt())
                .createdAt(document.getCreatedAt())
                .build();
    }
}