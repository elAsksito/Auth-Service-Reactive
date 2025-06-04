package dev.ask.auth.infrastructure.persistence.repository.implementation;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.TokenRepository;
import dev.ask.auth.infrastructure.persistence.document.TokenDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataTokenRepository;
import dev.ask.auth.shared.enums.TokenType;
import dev.ask.auth.shared.utils.HashUtil;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

    private final SpringDataTokenRepository repository;

    @Override
    public Mono<TokenDocument> saveToken(String userId, String token, String ipAddress, String userAgent) {
        byte[] tokenHash = HashUtil.hashToken(token);

        Instant now = Instant.now();
        Instant expiresAt = now.plus(30, ChronoUnit.DAYS);

        TokenDocument document = TokenDocument.builder()
                .userId(userId)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .tokenHash(tokenHash)
                .tokenType(TokenType.REFRESH)
                .isRevoked(false)
                .createdAt(now)
                .expiresAt(expiresAt)
                .build();

        document.prePersist();

        return repository.save(document);
    }
}
