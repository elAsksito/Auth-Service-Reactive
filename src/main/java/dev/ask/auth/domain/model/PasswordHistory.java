package dev.ask.auth.domain.model;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordHistory {
    private String id;
    private String userId;
    private String passwordHash;
    private Instant changedAt;
}