package dev.ask.auth.infrastructure.persistence.mapper;

import dev.ask.auth.domain.model.AuditLog;
import dev.ask.auth.infrastructure.persistence.document.AuditLogDocument;

public class AuditLogMapper {
    public static AuditLogDocument toDocument(AuditLog auditLog) {
        if (auditLog == null)
            return null;

        return AuditLogDocument.builder()
                .id(auditLog.getId())
                .userId(auditLog.getUserId())
                .action(auditLog.getAction())
                .metadata(auditLog.getMetadata())
                .ipAddress(auditLog.getIpAddress())
                .userAgent(auditLog.getUserAgent())
                .createdAt(auditLog.getCreatedAt())
                .build();
    }

    public static AuditLog toDomain(AuditLogDocument document) {
        if (document == null)
            return null;

        return AuditLog.builder()
                .id(document.getId())
                .userId(document.getUserId())
                .action(document.getAction())
                .metadata(document.getMetadata())
                .ipAddress(document.getIpAddress())
                .userAgent(document.getUserAgent())
                .createdAt(document.getCreatedAt())
                .build();
    }
}