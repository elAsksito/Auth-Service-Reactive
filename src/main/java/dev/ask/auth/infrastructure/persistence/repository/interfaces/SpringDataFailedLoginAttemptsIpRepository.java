package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import dev.ask.auth.infrastructure.persistence.document.FailedLoginAttemptsIpDocument;
import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SpringDataFailedLoginAttemptsIpRepository extends ReactiveMongoRepository<FailedLoginAttemptsIpDocument, String>{
    Mono<Boolean> existsByIpAddress(String ipAddress);
}