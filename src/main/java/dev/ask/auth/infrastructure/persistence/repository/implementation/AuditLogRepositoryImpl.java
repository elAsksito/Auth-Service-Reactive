package dev.ask.auth.infrastructure.persistence.repository.implementation;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.AuditLogRepository;
import dev.ask.auth.infrastructure.persistence.document.AuditLogDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataAuditLogRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AuditLogRepositoryImpl implements AuditLogRepository{

    private final SpringDataAuditLogRepository springDataAuditLogRepository;

    @Override
    public Mono<AuditLogDocument> save(String userId, String action, String ipAddress, String userAgent) {
        return null;
    }
    
}