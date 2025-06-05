package dev.ask.auth.application.service.session;

import dev.ask.auth.domain.repository.SessionRepository;
import dev.ask.auth.domain.service.session.IsSessionValidService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class IsSessionValidServiceImpl implements IsSessionValidService {
    private final SessionRepository sessionRepository;

    @Override
    public Mono<Boolean> isSessionValid(String userId, String accessToken) {
        return sessionRepository.isSessionActive(userId);
    }
}