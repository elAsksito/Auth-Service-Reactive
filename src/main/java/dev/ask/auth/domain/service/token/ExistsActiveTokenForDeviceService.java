package dev.ask.auth.domain.service.token;

import reactor.core.publisher.Mono;

public interface ExistsActiveTokenForDeviceService {
    Mono<Boolean> existsActiveTokenForDevice(String userId, String ipAddress, String userAgent);
}