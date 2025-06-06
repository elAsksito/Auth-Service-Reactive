package dev.ask.auth.domain.service.token;

import dev.ask.auth.domain.model.Token;
import reactor.core.publisher.Mono;

public interface FindValidTokenForDeviceService {
    Mono<Token> findValidToken(String userId, String ipAddress, String userAgent);
}