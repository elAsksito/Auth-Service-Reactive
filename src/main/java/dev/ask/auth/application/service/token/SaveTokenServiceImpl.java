package dev.ask.auth.application.service.token;

import dev.ask.auth.application.payload.response.TokenResponse;
import dev.ask.auth.domain.repository.TokenRepository;
import dev.ask.auth.domain.service.token.SaveTokenService;
import dev.ask.auth.infrastructure.persistence.mapper.TokenMapper;
import dev.ask.auth.infrastructure.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaveTokenServiceImpl implements SaveTokenService {

    private final TokenRepository tokenRepository;
    private final JwtService jwtService;

    @Override
    public Mono<TokenResponse> saveToken(String userId, String ipAddress, String userAgent) {
        return jwtService.generateToken(userId, ipAddress, userAgent)
                .flatMap(token -> tokenRepository.saveToken(userId, token, ipAddress, userAgent)
                        .map(TokenMapper::toDomain)
                        .map(savedToken -> TokenResponse.builder()
                                .accessToken(token)
                                .build()));
    }
}