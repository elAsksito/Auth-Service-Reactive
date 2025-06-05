package dev.ask.auth.application.service.session;

import dev.ask.auth.domain.repository.SessionRepository;
import dev.ask.auth.domain.service.session.IsSessionActiveService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class IsSessionActiveServiceImpl implements IsSessionActiveService {

    private final SessionRepository sessionRepository;

    @Override
    public Mono<Boolean> isSessionActive(String userId) {
        return sessionRepository.isSessionActive(userId);
    }
}