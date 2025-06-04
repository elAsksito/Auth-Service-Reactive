package dev.ask.auth.application.service.audit_log;

import dev.ask.auth.domain.repository.AuditLogRepository;
import dev.ask.auth.domain.service.audit_log.CreateAuditLogService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAuditLogServiceImpl implements CreateAuditLogService{

    private final AuditLogRepository auditLogRepository;

    
}