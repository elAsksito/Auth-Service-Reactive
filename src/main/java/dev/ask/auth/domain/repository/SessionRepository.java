package dev.ask.auth.domain.repository;

import reactor.core.publisher.Mono;

public interface SessionRepository {
    Mono<Void> createSession(String userId, String sessionId, String accessToken, String ipAddress, String userAgent);
    Mono<Boolean> isSessionActive(String userId);
    Mono<Boolean> isSessionValid(String userId, String accessToken);
    Mono<Void> revokeSession(String userId);
    Mono<Void> revokeAllSessions(String userId);
    Mono<Void> updateLastActivity(String sessionId);
}