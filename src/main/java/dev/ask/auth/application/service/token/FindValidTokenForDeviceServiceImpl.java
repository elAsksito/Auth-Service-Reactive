package dev.ask.auth.application.service.token;

import java.time.Instant;

import dev.ask.auth.domain.model.Token;
import dev.ask.auth.domain.repository.TokenRepository;
import dev.ask.auth.domain.service.token.FindValidTokenForDeviceService;
import dev.ask.auth.infrastructure.persistence.mapper.TokenMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindValidTokenForDeviceServiceImpl implements FindValidTokenForDeviceService {

    private final TokenRepository tokenRepository;

    @Override
    public Mono<Token> findValidToken(String userId, String ipAddress, String userAgent) {
        return tokenRepository
                .findFirstByUserIdAndIpAddressAndUserAgentAndIsRevokedFalseOrderByCreatedAtDesc(userId, ipAddress,
                        userAgent)
                .filter(token -> token.getExpiresAt().isAfter(Instant.now())).map(TokenMapper::toDomain);
    }
}