package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.SuspiciousActivityDocument;
import reactor.core.publisher.Mono;

public interface SuspiciousActivityRepository {
    Mono<SuspiciousActivityDocument> saveSuspiciousActivity(
            String userId,
            String ipAddress,
            String userAgent,
            String fingerprint,
            String reason);
}