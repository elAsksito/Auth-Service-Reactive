package dev.ask.auth.domain.service.session;

import reactor.core.publisher.Mono;

public interface UpdateLastActivityService {
    Mono<Void> updateLastActivity(String sessionId);
}