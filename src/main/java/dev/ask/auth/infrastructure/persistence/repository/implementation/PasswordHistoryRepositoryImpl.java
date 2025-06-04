package dev.ask.auth.infrastructure.persistence.repository.implementation;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.PasswordHistoryRepository;
import dev.ask.auth.infrastructure.persistence.document.PasswordHistoryDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataPasswordHistoryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class PasswordHistoryRepositoryImpl implements PasswordHistoryRepository {

    private final SpringDataPasswordHistoryRepository repository;

    @Override
    public Mono<PasswordHistoryDocument> savePasswordHistory(String userId, String passwordHash) {
        PasswordHistoryDocument document = PasswordHistoryDocument.builder()
                .userId(userId)
                .passwordHash(passwordHash)
                .build();
        document.prePersist();

        return repository.save(document);
    }

    @Override
    public Mono<Boolean> isPasswordUsed(String userId, String passwordHash) {
        return repository.findByUserIdAndPasswordHash(userId, passwordHash)
                .hasElement();
    }
}