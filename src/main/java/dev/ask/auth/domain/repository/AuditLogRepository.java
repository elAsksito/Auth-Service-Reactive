package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.AuditLogDocument;
import dev.ask.auth.infrastructure.persistence.document.UserDocument;
import reactor.core.publisher.Mono;

public interface AuditLogRepository {
    public Mono<AuditLogDocument> save(UserDocument user, String action, String ipAddress, String userAgent);
}