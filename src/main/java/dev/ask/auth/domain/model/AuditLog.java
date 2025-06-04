package dev.ask.auth.domain.model;

import java.time.Instant;

import dev.ask.auth.shared.enums.Action;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditLog {
    private String id;
    private String userId;
    private Action action;
    private String metadata;
    private String ipAddress;
    private String userAgent;
    private Instant createdAt;
}