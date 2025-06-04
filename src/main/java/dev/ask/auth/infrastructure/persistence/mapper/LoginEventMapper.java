package dev.ask.auth.infrastructure.persistence.mapper;

import dev.ask.auth.domain.model.LoginEvent;
import dev.ask.auth.infrastructure.persistence.document.LoginEventDocument;

public class LoginEventMapper {
    public static LoginEventDocument toDocument(LoginEvent domain) {
        if (domain == null)
            return null;

        return LoginEventDocument.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .ipAddress(domain.getIpAddress())
                .userAgent(domain.getUserAgent())
                .deviceFingerprint(domain.getDeviceFingerprint())
                .success(domain.getSuccess())
                .failureReason(domain.getFailureReason())
                .geoCountry(domain.getGeoCountry())
                .geoCity(domain.getGeoCity())
                .timestamp(domain.getTimestamp())
                .build();
    }

    public static LoginEvent toDomain(LoginEventDocument document) {
        if (document == null)
            return null;

        return LoginEvent.builder()
                .id(document.getId())
                .userId(document.getUserId())
                .ipAddress(document.getIpAddress())
                .userAgent(document.getUserAgent())
                .deviceFingerprint(document.getDeviceFingerprint())
                .success(document.getSuccess())
                .failureReason(document.getFailureReason())
                .geoCountry(document.getGeoCountry())
                .geoCity(document.getGeoCity())
                .timestamp(document.getTimestamp())
                .build();
    }
}
