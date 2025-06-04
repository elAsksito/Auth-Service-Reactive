package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.TokenDocument;
import reactor.core.publisher.Mono;

public interface TokenRepository {
    Mono<TokenDocument> saveToken(String userId, String ipAddress, String userAgent);
}