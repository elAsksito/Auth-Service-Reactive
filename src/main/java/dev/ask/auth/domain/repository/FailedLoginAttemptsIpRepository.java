package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.FailedLoginAttemptsIpDocument;
import reactor.core.publisher.Mono;

public interface FailedLoginAttemptsIpRepository {
    Mono<FailedLoginAttemptsIpDocument> handleFailedLogin(String ipAddress);
}