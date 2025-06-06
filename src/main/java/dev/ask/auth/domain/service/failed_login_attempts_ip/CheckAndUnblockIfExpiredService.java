package dev.ask.auth.domain.service.failed_login_attempts_ip;

import reactor.core.publisher.Mono;

public interface CheckAndUnblockIfExpiredService {
    public Mono<Void> checkAndUnblockIfExpired(String ipAddress);
}