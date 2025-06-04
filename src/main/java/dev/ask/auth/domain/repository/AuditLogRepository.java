package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.AuditLogDocument;
import reactor.core.publisher.Mono;

public interface AuditLogRepository {
    Mono<AuditLogDocument> save(String userId, String action, String ipAddress, String userAgent);
}