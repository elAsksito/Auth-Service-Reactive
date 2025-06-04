package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.LoginEventDocument;
import reactor.core.publisher.Mono;

public interface LoginEventRepository {
        Mono<LoginEventDocument> successLoginEvent(String userId, String ipAddress,
                        String userAgent, String fingerprint);

        Mono<LoginEventDocument> failedLoginEvent(String userId, String ipAddress,
                        String userAgent, String fingerprint, String failureReason);
}