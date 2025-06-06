package dev.ask.auth.domain.service.session;

import dev.ask.auth.application.payload.response.TokenResponse;
import reactor.core.publisher.Mono;

public interface RotateSessionService {
    Mono<TokenResponse> rotateSession(String oldRefreshToken, String ipAddress, String userAgent);
}