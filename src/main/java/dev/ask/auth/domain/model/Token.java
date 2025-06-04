package dev.ask.auth.domain.model;

import java.time.Instant;

import dev.ask.auth.shared.enums.TokenType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Token {
    private String id;
    private String userId;
    private byte[] tokenHash;
    private TokenType tokenType;
    private String userAgent;
    private String ipAddress;
    private boolean isRevoked;
    private Instant revokedAt;
    private String parentTokenId;
    private Instant expiresAt;
    private Instant createdAt;
}