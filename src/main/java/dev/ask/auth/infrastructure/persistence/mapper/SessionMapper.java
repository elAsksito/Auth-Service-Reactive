package dev.ask.auth.infrastructure.persistence.mapper;

import dev.ask.auth.domain.model.Session;
import dev.ask.auth.infrastructure.persistence.document.SessionDocument;

public class SessionMapper {
    public static SessionDocument toDocument(Session domain) {
        if (domain == null)
            return null;

        return SessionDocument.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .sessionTokenHash(domain.getSessionTokenHash())
                .userAgent(domain.getUserAgent())
                .ipAddress(domain.getIpAddress())
                .createdAt(domain.getCreatedAt())
                .expiresAt(domain.getExpiresAt())
                .isRevoked(domain.isRevoked())
                .revokedAt(domain.getRevokedAt())
                .lastActivity(domain.getLastActivity())
                .build();
    }

    public static Session toDomain(SessionDocument document) {
        if (document == null)
            return null;

        return Session.builder()
                .id(document.getId())
                .userId(document.getUserId())
                .sessionTokenHash(document.getSessionTokenHash())
                .userAgent(document.getUserAgent())
                .ipAddress(document.getIpAddress())
                .createdAt(document.getCreatedAt())
                .expiresAt(document.getExpiresAt())
                .isRevoked(document.isRevoked())
                .revokedAt(document.getRevokedAt())
                .lastActivity(document.getLastActivity())
                .build();
    }
}