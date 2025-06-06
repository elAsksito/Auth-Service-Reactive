package dev.ask.auth.domain.service.session;

import reactor.core.publisher.Mono;

public interface RevokeSessionService {
    Mono<Void> revokeSession(String userId, String ipAddress, String userAgent);
}