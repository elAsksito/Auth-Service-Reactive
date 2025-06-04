package dev.ask.auth.domain.model;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Session {
    private String id;
    private String userId;
    private byte[] sessionTokenHash;
    private String userAgent;
    private String ipAddress;
    private Instant createdAt;
    private Instant expiresAt;
    private boolean isRevoked;
    private Instant revokedAt;
    private Instant lastActivity;
}