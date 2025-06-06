package dev.ask.auth.application.service.token;

import java.util.UUID;

import dev.ask.auth.application.payload.response.TokenResponse;
import dev.ask.auth.domain.repository.TokenRepository;
import dev.ask.auth.domain.service.session.CreateSessionService;
import dev.ask.auth.domain.service.token.SaveTokenService;
import dev.ask.auth.infrastructure.persistence.mapper.TokenMapper;
import dev.ask.auth.infrastructure.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaveTokenServiceImpl implements SaveTokenService {

    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final CreateSessionService createSessionService;

    @Override
    public Mono<TokenResponse> saveToken(String userId, String ipAddress, String userAgent) {
        String sessionId = UUID.randomUUID().toString();
        return jwtService.generateToken(userId, sessionId, ipAddress, userAgent)
                .flatMap(accessTokenWithSession -> jwtService
                        .generateRefreshToken(userId, accessTokenWithSession.sessionId())
                        .flatMap(refreshToken -> createSessionService.createSession(
                                userId,
                                accessTokenWithSession.sessionId(),
                                refreshToken,
                                ipAddress,
                                userAgent).then(
                                        tokenRepository.saveToken(userId, refreshToken, ipAddress, userAgent)
                                                .map(TokenMapper::toDomain)
                                                .map(savedToken -> TokenResponse.builder()
                                                        .accessToken(accessTokenWithSession.token())
                                                        .refreshToken(refreshToken)
                                                        .build()))));
    }
}