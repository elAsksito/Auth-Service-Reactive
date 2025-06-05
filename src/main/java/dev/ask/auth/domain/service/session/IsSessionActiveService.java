package dev.ask.auth.domain.service.session;

import reactor.core.publisher.Mono;

public interface IsSessionActiveService {
    Mono<Boolean> isSessionActive(String userId);
}