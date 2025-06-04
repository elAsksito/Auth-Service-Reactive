package dev.ask.auth.domain.repository;

import dev.ask.auth.infrastructure.persistence.document.IpBlockDocument;
import reactor.core.publisher.Mono;

public interface IpBlockRepository {
    Mono<Boolean> isIpBlocked(String ipAddress);
    Mono<IpBlockDocument> blockIp(String ipAddress, int minutes, String reason);
    Mono<IpBlockDocument> unblockIp(String ipAddress);
}