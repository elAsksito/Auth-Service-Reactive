package dev.ask.auth.application.service.login_event;

import dev.ask.auth.domain.model.LoginEvent;
import dev.ask.auth.domain.repository.LoginEventRepository;
import dev.ask.auth.domain.service.login_event.FailedLoginEventService;
import dev.ask.auth.infrastructure.persistence.mapper.LoginEventMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FailedLoginEventServiceImpl implements FailedLoginEventService {

    private final LoginEventRepository loginEventRepository;

    @Override
    public Mono<LoginEvent> failedLoginEvent(String userId, String ipAddress, String userAgent, String fingerprint,
            String failureReason) {
        return loginEventRepository.failedLoginEvent(userId, ipAddress, userAgent, fingerprint, failureReason)
                .map(LoginEventMapper::toDomain);
    }

}