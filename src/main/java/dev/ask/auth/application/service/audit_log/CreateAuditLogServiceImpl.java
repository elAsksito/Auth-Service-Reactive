package dev.ask.auth.application.service.audit_log;

import java.util.Map;

import dev.ask.auth.domain.model.AuditLog;
import dev.ask.auth.domain.repository.AuditLogRepository;
import dev.ask.auth.domain.service.audit_log.CreateAuditLogService;
import dev.ask.auth.domain.vo.UserId;
import dev.ask.auth.infrastructure.persistence.mapper.AuditLogMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateAuditLogServiceImpl implements CreateAuditLogService {

    private final AuditLogRepository auditLogRepository;

    @Override
    public Mono<AuditLog> save(String userId, String action, String ipAddress, String userAgent,
            Map<String, Object> metadata) {

        UserId idUser = new UserId(userId);
        return auditLogRepository.save(idUser.value(), action, ipAddress, userAgent, metadata)
                .map(AuditLogMapper::toDomain);
    }
}