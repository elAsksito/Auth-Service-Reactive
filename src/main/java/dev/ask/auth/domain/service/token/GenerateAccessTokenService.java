package dev.ask.auth.domain.service.token;

import reactor.core.publisher.Mono;

public interface GenerateAccessTokenService {
    Mono<String> generateToken(String userId, String sessionId, String ipAddress, String userAgent);
}