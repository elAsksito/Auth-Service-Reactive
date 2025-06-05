package dev.ask.auth.application.service.failed_login_attempts_ip;

import dev.ask.auth.domain.model.FailedLoginAttemptsIp;
import dev.ask.auth.domain.repository.FailedLoginAttemptsIpRepository;
import dev.ask.auth.domain.service.failed_login_attempts_ip.HandleFailedLoginService;
import dev.ask.auth.infrastructure.persistence.mapper.FailedLoginAttemptsIpMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class HandleFailedLoginServiceImpl implements HandleFailedLoginService {

    private final FailedLoginAttemptsIpRepository failedLoginAttemptsIpRepository;

    @Override
    public Mono<FailedLoginAttemptsIp> handleFailedLogin(String ipAddress) {
        return failedLoginAttemptsIpRepository.handleFailedLogin(ipAddress).map(FailedLoginAttemptsIpMapper::toDomain);
    }
}