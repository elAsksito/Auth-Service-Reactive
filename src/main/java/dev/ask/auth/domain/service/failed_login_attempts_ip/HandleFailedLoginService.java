package dev.ask.auth.domain.service.failed_login_attempts_ip;

import dev.ask.auth.domain.model.FailedLoginAttemptsIp;
import reactor.core.publisher.Mono;

public interface HandleFailedLoginService {
    Mono<FailedLoginAttemptsIp> handleFailedLogin(String ipAddress);
}