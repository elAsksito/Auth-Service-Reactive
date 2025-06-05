package dev.ask.auth.domain.service.login_event;

import dev.ask.auth.domain.model.LoginEvent;
import reactor.core.publisher.Mono;

public interface SuccessLoginEventService {
    Mono<LoginEvent> successLoginEvent(String userId, String ipAddress,
            String userAgent, String fingerprint);
}