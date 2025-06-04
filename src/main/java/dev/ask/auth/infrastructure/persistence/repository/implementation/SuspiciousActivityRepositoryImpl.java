package dev.ask.auth.infrastructure.persistence.repository.implementation;

import java.time.Instant;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.SuspiciousActivityRepository;
import dev.ask.auth.infrastructure.persistence.document.SuspiciousActivityDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataSuspiciousActivityRepository;
import dev.ask.auth.shared.enums.Severity;
import dev.ask.auth.shared.enums.SuspiciousActivityReason;
import dev.ask.auth.shared.mapper.SeverityMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SuspiciousActivityRepositoryImpl implements SuspiciousActivityRepository {

    private final SpringDataSuspiciousActivityRepository repository;

    @Override
    public Mono<SuspiciousActivityDocument> saveSuspiciousActivity(String userId, String ipAddress, String userAgent,
            String fingerprint, SuspiciousActivityReason reason) {

        Severity severity = SeverityMapper.determineSeverity(reason);
        String details = String.format("Actividad sospechosa desde IP %s, dispositivo %s, motivo: %s",
                ipAddress, fingerprint, reason);

        SuspiciousActivityDocument document = SuspiciousActivityDocument.builder()
                .userId(userId)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .deviceFingerprint(fingerprint)
                .reason(reason)
                .severity(severity)
                .details(details)
                .timestamp(Instant.now())
                .build();

        return repository.save(document);
    }
}