package dev.ask.auth.application.service.ip_block;

import dev.ask.auth.domain.model.IpBlock;
import dev.ask.auth.domain.repository.IpBlockRepository;
import dev.ask.auth.domain.service.ip_block.UnblockIpService;
import dev.ask.auth.infrastructure.persistence.mapper.IpBlockMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UnblockIpServiceImpl implements UnblockIpService {

    private final IpBlockRepository repository;

    @Override
    public Mono<IpBlock> unblockIp(String ipAddress) {
        return repository.unblockIp(ipAddress).map(IpBlockMapper::toDomain);
    }
}