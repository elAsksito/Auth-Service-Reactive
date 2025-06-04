package dev.ask.auth.infrastructure.persistence.mapper;

import dev.ask.auth.domain.model.Token;
import dev.ask.auth.infrastructure.persistence.document.TokenDocument;

public class TokenMapper {
    public static TokenDocument toDocument(Token domain) {
        if (domain == null)
            return null;

        return TokenDocument.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .tokenHash(domain.getTokenHash())
                .tokenType(domain.getTokenType())
                .userAgent(domain.getUserAgent())
                .ipAddress(domain.getIpAddress())
                .isRevoked(domain.isRevoked())
                .revokedAt(domain.getRevokedAt())
                .parentTokenId(domain.getParentTokenId())
                .expiresAt(domain.getExpiresAt())
                .createdAt(domain.getCreatedAt())
                .build();
    }

    public static Token toDomain(TokenDocument document) {
        if (document == null)
            return null;

        return Token.builder()
                .id(document.getId())
                .userId(document.getUserId())
                .tokenHash(document.getTokenHash())
                .tokenType(document.getTokenType())
                .userAgent(document.getUserAgent())
                .ipAddress(document.getIpAddress())
                .isRevoked(document.isRevoked())
                .revokedAt(document.getRevokedAt())
                .parentTokenId(document.getParentTokenId())
                .expiresAt(document.getExpiresAt())
                .createdAt(document.getCreatedAt())
                .build();
    }
}