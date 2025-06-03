package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import java.time.Instant;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.AuditLogDocument;
import reactor.core.publisher.Flux;


public interface SpringDataAuditLogRepository extends ReactiveMongoRepository<AuditLogDocument, String> {
    Flux<AuditLogDocument> findByUserId(String userId);
    Flux<AuditLogDocument> findByUserIdAndCreatedAtAfter(String userId, Instant since);
    Flux<AuditLogDocument> findByIpAddress(String ipAddress);
}