package dev.ask.auth.infrastructure.persistence.repository.implementation;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.PasswordResetCodeRepository;
import dev.ask.auth.infrastructure.persistence.document.PasswordResetCodeDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataPasswordResetCodeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class PasswordResetCodeRepositoryImpl implements PasswordResetCodeRepository {

    private final SpringDataPasswordResetCodeRepository repository;

    @Override
    public Mono<Void> saveResetCode(String email, String code, Duration duration) {
        PasswordResetCodeDocument doc = PasswordResetCodeDocument.builder()
                .email(email)
                .code(code)
                .expiresAt(Instant.now().plus(duration))
                .build();
        return repository.save(doc).then();
    }

    @Override
    public Mono<Boolean> verifyCode(String email, String code) {
        return repository.findById(email)
                .filter(doc -> doc.getExpiresAt().isAfter(Instant.now()) && doc.getCode().equals(code))
                .hasElement();
    }

    @Override
    public Mono<Void> deleteCode(String email) {
        return repository.deleteById(email);
    }

}