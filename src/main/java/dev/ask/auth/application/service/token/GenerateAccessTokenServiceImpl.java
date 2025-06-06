package dev.ask.auth.application.service.token;

import dev.ask.auth.domain.service.token.GenerateAccessTokenService;
import dev.ask.auth.infrastructure.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GenerateAccessTokenServiceImpl implements GenerateAccessTokenService {

    private final JwtService jwtService;

    @Override
    public Mono<String> generateToken(String userId, String sessionId, String ipAddress, String userAgent) {
        return jwtService.generateToken(userId, ipAddress, userAgent, sessionId)
                .map(token -> token.token());
    }
}