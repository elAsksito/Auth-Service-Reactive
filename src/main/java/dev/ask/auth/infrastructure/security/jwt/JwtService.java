package dev.ask.auth.infrastructure.security.jwt;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import dev.ask.auth.domain.model.User;
import dev.ask.auth.domain.service.session.IsSessionValidService;
import dev.ask.auth.domain.service.user.FindUserByIdService;
import dev.ask.auth.domain.vo.AccessTokenWithSession;
import dev.ask.auth.infrastructure.security.utils.TokenExpiration;
import dev.ask.auth.shared.exception.auth_exceptions.InvalidJwtTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtService {

    private final IsSessionValidService sessionValidService;
    private final FindUserByIdService findUserByIdService;
    private final PrivateKey jwtPrivateKey;
    private final PublicKey jwtPublicKey;

    public Mono<AccessTokenWithSession> generateToken(String userId, String sessionId, String ipAddress, String userAgent) {
        return getUserById(userId).map(user -> {
            String token = Jwts.builder()
                    .subject(user.getId())
                    .issuedAt(new Date())
                    .expiration(Date.from(Instant.now().plusSeconds(TokenExpiration.ACCESS.getSeconds())))
                    .claims(Map.of(
                            "email", user.getEmail(),
                            "roles", user.getRoles(),
                            "sessionId", sessionId))
                    .signWith(jwtPrivateKey)
                    .compact();
            return new AccessTokenWithSession(token, sessionId);
        });
    }

    public Mono<String> generateRefreshToken(String userId, String sessionId) {
        return getUserById(userId).map(user -> {
            String token = Jwts.builder()
                    .subject(user.getId())
                    .issuedAt(new Date())
                    .expiration(Date.from(Instant.now().plusSeconds(TokenExpiration.REFRESH.getSeconds())))
                    .claims(Map.of(
                            "sessionId", sessionId))
                    .signWith(jwtPrivateKey)
                    .compact();
            return token;
        });
    }

    public Mono<Boolean> isTokenValid(String token) {
        try {
            Claims claims = extractAllClaims(token);
            String sessionId = claims.get("sessionId", String.class);
            if (sessionId == null) {
                log.warn("Token no tiene sessionId");
                return Mono.error(new InvalidJwtTokenException());
            }
            return sessionValidService.isSessionValid(sessionId, token)
                    .onErrorResume(e -> {
                        log.error("Error validando token: {}", e.getMessage());
                        return Mono.just(false);
                    });

        } catch (Exception e) {
            log.error("Error parsing JWT: {}", e.getMessage());
            return Mono.just(false);
        }
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(jwtPublicKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Mono<User> getUserById(String userId) {
        return findUserByIdService.findById(userId);
    }
}