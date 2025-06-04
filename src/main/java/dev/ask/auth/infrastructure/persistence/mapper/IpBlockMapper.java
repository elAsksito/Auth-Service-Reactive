package dev.ask.auth.infrastructure.persistence.mapper;

import dev.ask.auth.domain.model.IpBlock;
import dev.ask.auth.infrastructure.persistence.document.IpBlockDocument;

public class IpBlockMapper {
    public static IpBlockDocument toDocument(IpBlock domain) {
        if (domain == null)
            return null;

        return IpBlockDocument.builder()
                .ipAddress(domain.getIpAddress())
                .blockedUntil(domain.getBlockedUntil())
                .reason(domain.getReason())
                .createdAt(domain.getCreatedAt())
                .build();
    }

    public static IpBlock toDomain(IpBlockDocument document) {
        if (document == null)
            return null;

        return IpBlock.builder()
                .ipAddress(document.getIpAddress())
                .blockedUntil(document.getBlockedUntil())
                .reason(document.getReason())
                .createdAt(document.getCreatedAt())
                .build();
    }
}
