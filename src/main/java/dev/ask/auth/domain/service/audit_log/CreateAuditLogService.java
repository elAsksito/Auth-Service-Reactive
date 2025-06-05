package dev.ask.auth.domain.service.audit_log;

import java.util.Map;

import dev.ask.auth.domain.model.AuditLog;
import reactor.core.publisher.Mono;

public interface CreateAuditLogService {
    Mono<AuditLog> save(String userId, String action, String ipAddress, String userAgent,
            Map<String, Object> metadata);
}