package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.domain.repository.SessionRepository;
import dev.ask.auth.domain.service.session.CreateSessionService;
import dev.ask.auth.domain.service.session.IsSessionActiveService;
import dev.ask.auth.domain.service.session.IsSessionValidService;
import dev.ask.auth.domain.service.session.RevokeAllSessionsService;
import dev.ask.auth.domain.service.session.RevokeSessionService;
import dev.ask.auth.domain.service.session.UpdateLastActivityService;

@Configuration
public class SessionServiceConfig {

    @Bean
    CreateSessionService createSessionService(SessionRepository sessionRepository) {
        return sessionRepository::createSession;
    }

    @Bean
    IsSessionActiveService isSessionActiveService(SessionRepository sessionRepository) {
        return sessionRepository::isSessionActive;
    }

    @Bean
    IsSessionValidService isSessionValidService(SessionRepository sessionRepository) {
        return sessionRepository::isSessionValid;
    }

    @Bean
    RevokeAllSessionsService revokeAllSessionsService(SessionRepository sessionRepository) {
        return sessionRepository::revokeAllSessions;
    }

    @Bean
    RevokeSessionService revokeSessionService(SessionRepository sessionRepository) {
        return sessionRepository::revokeSession;
    }

    @Bean
    UpdateLastActivityService updateLastActivityService(SessionRepository sessionRepository) {
        return sessionRepository::updateLastActivity;
    }
}