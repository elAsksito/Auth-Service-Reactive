package dev.ask.auth.domain.model;

import java.time.Instant;

import dev.ask.auth.shared.enums.OneTokenType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OneTimeToken {
    private String id;
    private String userId;
    private byte[] tokenHash;
    private OneTokenType tokenType;
    private boolean isUsed;
    private Instant usedAt;
    private Instant expiresAt;
    private Instant createdAt;
} 