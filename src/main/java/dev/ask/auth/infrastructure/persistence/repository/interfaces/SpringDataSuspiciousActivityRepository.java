package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.SuspiciousActivityDocument;
import reactor.core.publisher.Flux;

public interface SpringDataSuspiciousActivityRepository extends ReactiveMongoRepository<SuspiciousActivityDocument, String> {
    Flux<SuspiciousActivityDocument> findByUserIdOrderByTimestampDesc(String userId);
}