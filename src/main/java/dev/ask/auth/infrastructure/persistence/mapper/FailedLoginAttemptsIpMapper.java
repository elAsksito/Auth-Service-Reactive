package dev.ask.auth.infrastructure.persistence.mapper;

import dev.ask.auth.domain.model.FailedLoginAttemptsIp;
import dev.ask.auth.infrastructure.persistence.document.FailedLoginAttemptsIpDocument;

public class FailedLoginAttemptsIpMapper {
    public static FailedLoginAttemptsIpDocument toDocument(FailedLoginAttemptsIp domain) {
        if (domain == null)
            return null;

        return FailedLoginAttemptsIpDocument.builder()
                .ipAddress(domain.getIpAddress())
                .attempts(domain.getAttempts())
                .lastAttempt(domain.getLastAttempt())
                .blockedUntil(domain.getBlockedUntil())
                .build();
    }

    public static FailedLoginAttemptsIp toDomain(FailedLoginAttemptsIpDocument document) {
        if (document == null)
            return null;

        return FailedLoginAttemptsIp.builder()
                .ipAddress(document.getIpAddress())
                .attempts(document.getAttempts())
                .lastAttempt(document.getLastAttempt())
                .blockedUntil(document.getBlockedUntil())
                .build();
    }
}