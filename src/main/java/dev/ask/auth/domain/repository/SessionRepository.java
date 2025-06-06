package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.SessionDocument;
import reactor.core.publisher.Mono;

public interface SessionRepository {
    Mono<Void> createSession(String userId, String sessionId, String accessToken, String ipAddress, String userAgent);
    Mono<Boolean> isSessionActive(String userId);
    Mono<Boolean> isSessionValid(String userId, String accessToken);
    Mono<Void> revokeSession(String userId, String ipAddress, String userAgent);
    Mono<Void> revokeAllSessions(String userId);
    Mono<Void> updateLastActivity(String sessionId);
    Mono<SessionDocument> getExistingSession(String userId, String ipAddress, String userAgent);
}