package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.AuditLogDocument;


public interface SpringDataAuditLogRepository extends ReactiveMongoRepository<AuditLogDocument, String> {
}