package dev.ask.auth.application.service.session;

import dev.ask.auth.domain.repository.SessionRepository;
import dev.ask.auth.domain.service.session.CreateSessionService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateSessionServiceImpl implements CreateSessionService {

    private final SessionRepository sessionRepository;

    @Override
    public Mono<Void> createSession(String userId, String sessionId, String refreshToken, String ipAddress,
            String userAgent) {
        return sessionRepository.createSession(userId, sessionId, refreshToken, ipAddress, userAgent);
    }
}