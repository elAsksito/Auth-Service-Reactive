package dev.ask.auth.domain.service.ip_block;

import dev.ask.auth.domain.model.IpBlock;
import reactor.core.publisher.Mono;

public interface UnblockIpService {
    Mono<IpBlock> unblockIp(String ipAddress);
}