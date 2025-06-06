package dev.ask.auth.application.service.failed_login_attempts_ip;

import dev.ask.auth.domain.repository.FailedLoginAttemptsIpRepository;
import dev.ask.auth.domain.service.failed_login_attempts_ip.CheckAndUnblockIfExpiredService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CheckAndUnblockIfExpiredServiceImpl implements CheckAndUnblockIfExpiredService {

    private final FailedLoginAttemptsIpRepository failedLoginAttemptsIpRepository;

    @Override
    public Mono<Void> checkAndUnblockIfExpired(String ipAddress) {
        return failedLoginAttemptsIpRepository.checkAndUnblockIfExpired(ipAddress);
    }
}