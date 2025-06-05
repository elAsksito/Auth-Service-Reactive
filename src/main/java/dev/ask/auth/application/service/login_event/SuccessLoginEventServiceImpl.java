package dev.ask.auth.application.service.login_event;

import dev.ask.auth.domain.model.LoginEvent;
import dev.ask.auth.domain.repository.LoginEventRepository;
import dev.ask.auth.domain.service.login_event.SuccessLoginEventService;
import dev.ask.auth.infrastructure.persistence.mapper.LoginEventMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SuccessLoginEventServiceImpl implements SuccessLoginEventService {

    private final LoginEventRepository loginEventRepository;

    @Override
    public Mono<LoginEvent> successLoginEvent(String userId, String ipAddress, String userAgent, String fingerprint) {
        return loginEventRepository.successLoginEvent(userId, ipAddress, userAgent, fingerprint)
                .map(LoginEventMapper::toDomain);
    }
}