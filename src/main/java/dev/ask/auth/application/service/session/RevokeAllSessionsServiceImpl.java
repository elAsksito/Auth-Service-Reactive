package dev.ask.auth.application.service.session;

import dev.ask.auth.domain.repository.SessionRepository;
import dev.ask.auth.domain.service.session.RevokeAllSessionsService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RevokeAllSessionsServiceImpl implements RevokeAllSessionsService {
    private final SessionRepository sessionRepository;

    @Override
    public Mono<Void> revokeAllSessions(String userId) {
        return sessionRepository.revokeAllSessions(userId);
    }
}