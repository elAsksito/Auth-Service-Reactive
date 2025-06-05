package dev.ask.auth.application.service.session;

import dev.ask.auth.domain.repository.SessionRepository;
import dev.ask.auth.domain.service.session.UpdateLastActivityService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateLastActivityServiceImpl implements UpdateLastActivityService {

    private final SessionRepository sessionRepository;

    @Override
    public Mono<Void> updateLastActivity(String sessionId) {
        return sessionRepository.updateLastActivity(sessionId);
    }
}