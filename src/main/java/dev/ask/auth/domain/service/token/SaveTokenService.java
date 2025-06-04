package dev.ask.auth.domain.service.token;

import dev.ask.auth.application.payload.response.TokenResponse;
import reactor.core.publisher.Mono;

public interface SaveTokenService {
    Mono<TokenResponse> saveToken(String userId, String token, String ipAddress, String userAgent);
}