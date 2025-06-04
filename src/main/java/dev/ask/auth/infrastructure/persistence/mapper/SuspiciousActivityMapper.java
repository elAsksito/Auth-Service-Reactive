package dev.ask.auth.infrastructure.persistence.mapper;

import dev.ask.auth.domain.model.SuspiciousActivity;
import dev.ask.auth.infrastructure.persistence.document.SuspiciousActivityDocument;

public class SuspiciousActivityMapper {
    public static SuspiciousActivityDocument toDocument(SuspiciousActivity domain) {
        if (domain == null)
            return null;

        return SuspiciousActivityDocument.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .ipAddress(domain.getIpAddress())
                .userAgent(domain.getUserAgent())
                .deviceFingerprint(domain.getDeviceFingerprint())
                .reason(domain.getReason())
                .severity(domain.getSeverity())
                .details(domain.getDetails())
                .timestamp(domain.getTimestamp())
                .build();
    }

    public static SuspiciousActivity toDomain(SuspiciousActivityDocument document) {
        if (document == null)
            return null;

        return SuspiciousActivity.builder()
                .id(document.getId())
                .userId(document.getUserId())
                .ipAddress(document.getIpAddress())
                .userAgent(document.getUserAgent())
                .deviceFingerprint(document.getDeviceFingerprint())
                .reason(document.getReason())
                .severity(document.getSeverity())
                .details(document.getDetails())
                .timestamp(document.getTimestamp())
                .build();
    }
}