package dev.ask.auth.domain.service.ip_block;

import reactor.core.publisher.Mono;

public interface IsIpBlockedService {
    Mono<Boolean> isIpBlocked(String ipAddress);
}