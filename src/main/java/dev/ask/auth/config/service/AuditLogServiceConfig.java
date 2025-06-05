package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.audit_log.CreateAuditLogServiceImpl;
import dev.ask.auth.domain.repository.AuditLogRepository;
import dev.ask.auth.domain.service.audit_log.CreateAuditLogService;

@Configuration
public class AuditLogServiceConfig {
    @Bean
    CreateAuditLogService createAuditLogService(AuditLogRepository auditLogRepository) {
        return new CreateAuditLogServiceImpl(auditLogRepository);
    }
}