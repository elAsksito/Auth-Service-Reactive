package dev.ask.auth.domain.service.session;

import reactor.core.publisher.Mono;

public interface RevokeAllSessionsService {
    Mono<Void> revokeAllSessions(String userId);
}