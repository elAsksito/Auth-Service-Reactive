package dev.ask.auth.domain.service.session;

import reactor.core.publisher.Mono;

public interface IsSessionValidService {
    Mono<Boolean> isSessionValid(String userId, String accessToken);
}