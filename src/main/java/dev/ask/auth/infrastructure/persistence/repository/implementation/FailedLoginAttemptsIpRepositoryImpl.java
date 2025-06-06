package dev.ask.auth.infrastructure.persistence.repository.implementation;

import java.time.Instant;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.FailedLoginAttemptsIpRepository;
import dev.ask.auth.domain.repository.IpBlockRepository;
import dev.ask.auth.infrastructure.persistence.document.FailedLoginAttemptsIpDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataFailedLoginAttemptsIpRepository;
import dev.ask.auth.shared.enums.BlockTime;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class FailedLoginAttemptsIpRepositoryImpl implements FailedLoginAttemptsIpRepository {

    private final SpringDataFailedLoginAttemptsIpRepository repository;
    private final IpBlockRepository ipBlockRepository;

    @Override
    public Mono<FailedLoginAttemptsIpDocument> handleFailedLogin(String ipAddress) {
        Instant now = Instant.now();
        BlockTime blockDuration = BlockTime.MINUTE;
        Instant blockedUntil = now.plusSeconds(blockDuration.getSeconds());

        return repository.findById(ipAddress)
                .flatMap(existing -> {
                    if (existing.getBlockedUntil() != null && existing.getBlockedUntil().isAfter(now)) {
                        return Mono.just(existing);
                    }

                    if (existing.getBlockedUntil() != null && existing.getBlockedUntil().isBefore(now)) {
                        existing.setAttempts(1);
                        existing.setBlockedUntil(null);
                        return ipBlockRepository.unblockIp(ipAddress)
                                .then(repository.save(existing));
                    }

                    existing.setAttempts(existing.getAttempts() + 1);
                    existing.prePersist();

                    if (existing.getAttempts() >= 5) {
                        existing.setBlockedUntil(blockedUntil);

                        return ipBlockRepository.blockIp(ipAddress, blockDuration.getSeconds(), "Demasiados intentos fallidos")
                                .then(repository.save(existing));
                    }

                    return repository.save(existing);
                })
                .switchIfEmpty(
                        repository.save(FailedLoginAttemptsIpDocument.builder()
                                .ipAddress(ipAddress)
                                .attempts(1)
                                .lastAttempt(now)
                                .build()));
    }

    @Override
    public Mono<Void> checkAndUnblockIfExpired(String ipAddress) {
    Instant now = Instant.now();
    return repository.findById(ipAddress)
            .flatMap(existing -> {
                if (existing.getBlockedUntil() != null && existing.getBlockedUntil().isBefore(now)) {
                    existing.setAttempts(1);
                    existing.setBlockedUntil(null);
                    return ipBlockRepository.unblockIp(ipAddress)
                            .then(repository.save(existing))
                            .then();
                }
                return Mono.empty();
            });
        }
}