package dev.ask.auth.domain.vo;

public record AccessTokenWithSession(String token, String sessionId) {
}