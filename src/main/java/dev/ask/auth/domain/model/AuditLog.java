package dev.ask.auth.domain.model;

import java.time.Instant;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditLog {
    private String id;
    private String userId;
    private String action;
    private Map<String, Object> metadata;
    private String ipAddress;
    private String userAgent;
    private Instant createdAt;
}