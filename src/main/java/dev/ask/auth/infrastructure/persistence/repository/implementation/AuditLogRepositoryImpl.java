package dev.ask.auth.infrastructure.persistence.repository.implementation;

import java.util.Map;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.AuditLogRepository;
import dev.ask.auth.infrastructure.persistence.document.AuditLogDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataAuditLogRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AuditLogRepositoryImpl implements AuditLogRepository {

    private final SpringDataAuditLogRepository springDataAuditLogRepository;

    @Override
    public Mono<AuditLogDocument> save(String userId, String action, String ipAddress, String userAgent,
            Map<String, Object> metadata) {
        AuditLogDocument auditLogDocument = AuditLogDocument.builder()
                .userId(userId)
                .action(action)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .metadata(metadata)
                .build();
        auditLogDocument.prePersist();
        return springDataAuditLogRepository.save(auditLogDocument);
    }
}