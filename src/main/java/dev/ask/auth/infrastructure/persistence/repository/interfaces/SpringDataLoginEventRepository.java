package dev.ask.auth.infrastructure.persistence.repository.interfaces;

import java.time.Instant;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.auth.infrastructure.persistence.document.LoginEventDocument;
import reactor.core.publisher.Flux;

public interface SpringDataLoginEventRepository extends ReactiveMongoRepository<LoginEventDocument, String> {
    Flux<LoginEventDocument> findByUserId(String userId);
    Flux<LoginEventDocument> findByUserIdAndTimestampAfter(String userId, Instant after);
    Flux<LoginEventDocument> findByIpAddress(String ipAddress);
    Flux<LoginEventDocument> findByDeviceFingerprint(String deviceFingerprint);
}