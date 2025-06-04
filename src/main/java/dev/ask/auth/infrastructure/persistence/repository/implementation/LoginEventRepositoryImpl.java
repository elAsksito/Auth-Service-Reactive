package dev.ask.auth.infrastructure.persistence.repository.implementation;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.LoginEventRepository;
import dev.ask.auth.infrastructure.persistence.document.LoginEventDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataLoginEventRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class LoginEventRepositoryImpl implements LoginEventRepository {

    private final SpringDataLoginEventRepository repository;

    @Override
    public Mono<LoginEventDocument> successLoginEvent(String userId, String ipAddress, String userAgent,
            String fingerprint) {
        LoginEventDocument document = LoginEventDocument.builder()
                .userId(userId)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .deviceFingerprint(fingerprint)
                .success(true)
                .failureReason(null)
                .build();
        document.prePersist();

        return repository.save(document);
    }

    @Override
    public Mono<LoginEventDocument> failedLoginEvent(String userId, String ipAddress, String userAgent,
            String fingerprint, String failureReason) {
        LoginEventDocument document = LoginEventDocument.builder()
                .userId(userId)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .deviceFingerprint(fingerprint)
                .success(false)
                .failureReason(failureReason)
                .build();

        document.prePersist();

        return repository.save(document);
    }
}