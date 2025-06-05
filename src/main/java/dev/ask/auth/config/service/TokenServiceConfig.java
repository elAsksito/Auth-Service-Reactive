package dev.ask.auth.config.service;

import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.token.SaveTokenServiceImpl;
import dev.ask.auth.domain.repository.TokenRepository;
import dev.ask.auth.domain.service.token.SaveTokenService;
import dev.ask.auth.infrastructure.security.jwt.JwtService;

@Configuration
public class TokenServiceConfig {
    SaveTokenService saveTokenService(TokenRepository tokenRepository, JwtService jwtService) {
        return new SaveTokenServiceImpl(tokenRepository, jwtService);
    }
}