package dev.ask.auth.infrastructure.persistence.repository.implementation;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.SessionRepository;
import dev.ask.auth.infrastructure.persistence.document.SessionDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataSessionRepository;
import dev.ask.auth.shared.utils.HashUtil;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {

    private final SpringDataSessionRepository repository;

    @Override
    public Mono<Void> createSession(String userId, String sessionId, String accessToken, String ipAddress,
            String userAgent) {
        byte[] tokenHash = HashUtil.hashToken(accessToken);
        Instant now = Instant.now();

        SessionDocument session = SessionDocument.builder()
                .id(sessionId)
                .userId(userId)
                .sessionTokenHash(tokenHash)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .createdAt(now)
                .expiresAt(now.plus(30, ChronoUnit.DAYS))
                .isRevoked(false)
                .lastActivity(now)
                .build();

        session.prePersist();

        return repository.save(session).then();
    }

    @Override
    public Mono<Boolean> isSessionActive(String userId) {
        return repository.findByUserIdAndIsRevokedFalse(userId)
                .hasElement();
    }

    @Override
    public Mono<Boolean> isSessionValid(String userId, String accessToken) {
        byte[] tokenHash = HashUtil.hashToken(accessToken);

        return repository.findByUserIdAndSessionTokenHashAndIsRevokedFalse(userId, tokenHash)
                .map(session -> session.getExpiresAt() != null &&
                        session.getExpiresAt().isAfter(Instant.now()))
                .defaultIfEmpty(false);
    }

    @Override
    public Mono<Void> revokeSession(String userId) {
        return repository.findByUserIdAndIsRevokedFalse(userId)
                .flatMap(session -> {
                    session.setRevoked(true);
                    session.setRevokedAt(Instant.now());
                    return repository.save(session);
                })
                .then();
    }

    @Override
    public Mono<Void> revokeAllSessions(String userId) {
        return repository.findAllByUserIdAndIsRevokedFalse(userId)
                .flatMap(session -> {
                    session.setRevoked(true);
                    session.setRevokedAt(Instant.now());
                    return repository.save(session);
                })
                .then();
    }

    @Override
    public Mono<Void> updateLastActivity(String sessionId) {
        return repository.findById(sessionId)
                .flatMap(session -> {
                    session.setLastActivity(Instant.now());
                    return repository.save(session);
                })
                .then();
    }
}
