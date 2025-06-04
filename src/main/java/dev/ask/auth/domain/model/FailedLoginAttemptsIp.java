package dev.ask.auth.domain.model;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FailedLoginAttemptsIp {
    private String ipAddress;
    private int attempts;
    private Instant lastAttempt;
    private Instant blockedUntil;
}