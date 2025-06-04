package dev.ask.auth.infrastructure.persistence.repository.implementation;

import java.time.Instant;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.IpBlockRepository;
import dev.ask.auth.infrastructure.persistence.document.IpBlockDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataIpBlockRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class IpBlockRepositoryImpl implements IpBlockRepository {

    private final SpringDataIpBlockRepository repository;

    @Override
    public Mono<Boolean> isIpBlocked(String ipAddress) {
        return repository.findById(ipAddress)
                .map(ipBlock -> ipBlock.getBlockedUntil() != null &&
                        ipBlock.getBlockedUntil().isAfter(java.time.Instant.now()))
                .defaultIfEmpty(false);
    }

    @Override
    public Mono<IpBlockDocument> blockIp(String ipAddress, int minutes, String reason) {
        return repository.findById(ipAddress)
                .defaultIfEmpty(IpBlockDocument.builder()
                        .ipAddress(ipAddress)
                        .createdAt(Instant.now())
                        .build())
                .flatMap(ipBlock -> {
                    ipBlock.setReason(reason);
                    ipBlock.setBlockedUntil(Instant.now().plusSeconds(minutes * 60L));
                    ipBlock.prePersist();
                    return repository.save(ipBlock);
                });
    }

    @Override
    public Mono<IpBlockDocument> unblockIp(String ipAddress) {
        return repository.findById(ipAddress)
                .flatMap(ipBlock -> {
                    ipBlock.setBlockedUntil(null);
                    ipBlock.setReason(null);
                    return repository.save(ipBlock);
                });
    }
}