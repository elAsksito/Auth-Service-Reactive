package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.OneTimeTokenDocument;
import dev.ask.auth.shared.enums.OneTokenType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface  SpringDataOneTimeTokenRepository extends ReactiveMongoRepository<OneTimeTokenDocument, String> {
    Mono<OneTimeTokenDocument> findByIdAndIsUsedFalse(String id);
    Flux<OneTimeTokenDocument> findByUserIdAndTokenTypeAndIsUsedFalse(String userId, OneTokenType tokenType);
    Mono<Boolean> existsByUserIdAndTokenTypeAndIsUsedFalse(String userId, OneTokenType tokenType);
}