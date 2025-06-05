package dev.ask.auth.domain.service.ip_block;

import dev.ask.auth.domain.model.IpBlock;
import reactor.core.publisher.Mono;

public interface BlockIpService {
    Mono<IpBlock> blockIp(String ipAddress, int minutes, String reason);
}