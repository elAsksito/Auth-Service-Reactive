package dev.ask.auth.application.service.ip_block;

import dev.ask.auth.domain.repository.IpBlockRepository;
import dev.ask.auth.domain.service.ip_block.IsIpBlockedService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class IsIpBlockedServiceImpl implements IsIpBlockedService {

    private final IpBlockRepository repository;

    @Override
    public Mono<Boolean> isIpBlocked(String ipAddress) {
        return repository.isIpBlocked(ipAddress);
    }
}