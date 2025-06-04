package dev.ask.auth.domain.model;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IpBlock {
    private String ipAddress;
    private Instant blockedUntil;
    private String reason;
    private Instant createdAt;
}