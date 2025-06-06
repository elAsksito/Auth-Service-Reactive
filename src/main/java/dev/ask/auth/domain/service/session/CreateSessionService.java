package dev.ask.auth.domain.service.session;

import reactor.core.publisher.Mono;

public interface CreateSessionService {
    Mono<Void> createSession(String userId, String sessionId, String refreshToken, String ipAddress,
            String userAgent);
}