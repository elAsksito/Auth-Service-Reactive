package dev.ask.auth.domain.service.login_event;

import dev.ask.auth.domain.model.LoginEvent;
import reactor.core.publisher.Mono;

public interface FailedLoginEventService {
    Mono<LoginEvent> failedLoginEvent(String userId, String ipAddress,
            String userAgent, String fingerprint, String failureReason);
}