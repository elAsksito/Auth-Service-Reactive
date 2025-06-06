package dev.ask.auth.application.service.session;

import dev.ask.auth.domain.model.Session;
import dev.ask.auth.domain.repository.SessionRepository;
import dev.ask.auth.domain.service.session.GetExistingSessionService;
import dev.ask.auth.infrastructure.persistence.mapper.SessionMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetExistingSessionServiceImpl implements GetExistingSessionService {

    private final SessionRepository sessionRepository;

    @Override
    public Mono<Session> getExistingSession(String userId, String ipAddress, String userAgent) {
        return sessionRepository.getExistingSession(userId, ipAddress, userAgent).map(SessionMapper::toDomain);
    }
}