package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.token.FindValidTokenForDeviceServiceImpl;
import dev.ask.auth.application.service.token.GenerateAccessTokenServiceImpl;
import dev.ask.auth.application.service.token.SaveTokenServiceImpl;
import dev.ask.auth.domain.repository.TokenRepository;
import dev.ask.auth.domain.service.session.CreateSessionService;
import dev.ask.auth.domain.service.token.ExistsActiveTokenForDeviceService;
import dev.ask.auth.domain.service.token.FindValidTokenForDeviceService;
import dev.ask.auth.domain.service.token.GenerateAccessTokenService;
import dev.ask.auth.domain.service.token.SaveTokenService;
import dev.ask.auth.infrastructure.security.jwt.JwtService;

@Configuration
public class TokenServiceConfig {
    @Bean
    SaveTokenService saveTokenService(TokenRepository tokenRepository, JwtService jwtService,
            CreateSessionService createSessionService) {
        return new SaveTokenServiceImpl(tokenRepository, jwtService, createSessionService);
    }

    @Bean
    ExistsActiveTokenForDeviceService existsActiveTokenForDeviceService(TokenRepository tokenRepository) {
        return tokenRepository::existsActiveTokenForDevice;
    }

    @Bean
    FindValidTokenForDeviceService findValidTokenForDeviceService(
            TokenRepository tokenRepository) {
        return new FindValidTokenForDeviceServiceImpl(tokenRepository);
    }

    @Bean
    GenerateAccessTokenService generateAccessTokenService(JwtService jwtService) {
        return new GenerateAccessTokenServiceImpl(jwtService);
    }
}