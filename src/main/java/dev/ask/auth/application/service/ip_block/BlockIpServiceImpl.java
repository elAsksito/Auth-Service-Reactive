package dev.ask.auth.application.service.ip_block;

import dev.ask.auth.domain.model.IpBlock;
import dev.ask.auth.domain.repository.IpBlockRepository;
import dev.ask.auth.domain.service.ip_block.BlockIpService;
import dev.ask.auth.infrastructure.persistence.mapper.IpBlockMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BlockIpServiceImpl implements BlockIpService {

    private final IpBlockRepository ipBlockRepository;

    @Override
    public Mono<IpBlock> blockIp(String ipAddress, int minutes, String reason) {
        return ipBlockRepository.blockIp(ipAddress, minutes, reason).map(IpBlockMapper::toDomain);
    }
}