package dev.ask.auth.application.service.session;

import dev.ask.auth.domain.repository.SessionRepository;
import dev.ask.auth.domain.service.session.RevokeSessionService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RevokeSessionServiceImpl implements RevokeSessionService {

    private final SessionRepository sessionRepository;

    @Override
    public Mono<Void> revokeSession(String userId) {
        return sessionRepository.revokeSession(userId);
    }
}