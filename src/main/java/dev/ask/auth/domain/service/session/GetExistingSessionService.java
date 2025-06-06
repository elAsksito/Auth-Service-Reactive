package dev.ask.auth.domain.service.session;

import dev.ask.auth.domain.model.Session;
import reactor.core.publisher.Mono;

public interface GetExistingSessionService {
    Mono<Session> getExistingSession(String userId, String ipAddress, String userAgent);
}