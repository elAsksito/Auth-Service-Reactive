package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.session.GetExistingSessionServiceImpl;
import dev.ask.auth.application.service.session.RotateSessionServiceImpl;
import dev.ask.auth.domain.repository.SessionRepository;
import dev.ask.auth.domain.service.session.CreateSessionService;
import dev.ask.auth.domain.service.session.GetExistingSessionService;
import dev.ask.auth.domain.service.session.IsSessionActiveService;
import dev.ask.auth.domain.service.session.IsSessionValidService;
import dev.ask.auth.domain.service.session.RevokeAllSessionsService;
import dev.ask.auth.domain.service.session.RevokeSessionService;
import dev.ask.auth.domain.service.session.RotateSessionService;
import dev.ask.auth.domain.service.session.UpdateLastActivityService;
import dev.ask.auth.domain.service.token.SaveTokenService;
import dev.ask.auth.infrastructure.security.jwt.JwtService;

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

    @Bean
    RotateSessionService rotateSessionService(JwtService jwtService, RevokeSessionService revokeSessionService,
            SaveTokenService saveTokenService, IsSessionValidService isSessionValidService) {
        return new RotateSessionServiceImpl(jwtService, revokeSessionService, saveTokenService, isSessionValidService);
    }

    @Bean
    GetExistingSessionService getExistingSessionService(SessionRepository sessionRepository) {
        return new GetExistingSessionServiceImpl(sessionRepository);
    }
}