package dev.ask.auth.infrastructure.security.jwt;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.ask.auth.infrastructure.persistence.document.UserDocument;
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

    // private final IsSessionValidService sessionValidService;
    private final PrivateKey jwtPrivateKey;
    private final PublicKey jwtPublicKey;

    public Mono<String> generateToken(UserDocument user, String ipAddress, String userAgent) {
        String sessionId = UUID.randomUUID().toString();

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

        return Mono.just(token);
    }

    public Mono<String> generateRefreshToken(UserDocument user) {
        String token = Jwts.builder()
                .subject(user.getId())
                .issuedAt(new Date())
                .expiration(Date.from(Instant.now().plusSeconds(TokenExpiration.REFRESH.getSeconds())))
                .signWith(jwtPrivateKey)
                .compact();
        return Mono.just(token);
    }

    public Mono<Boolean> isTokenValid(String token) {
        try {
            Claims claims = extractAllClaims(token);
            String sessionId = claims.get("sessionId", String.class);
            if (sessionId == null) {
                log.warn("Token no tiene sessionId");
                return Mono.error(new InvalidJwtTokenException());
            }

            return Mono.just(false);
            // return sessionValidService.isSessionValid(sessionId, token)
            //         .onErrorResume(e -> {
            //             log.error("Error validando token: {}", e.getMessage());
            //             return Mono.just(false);
            //         });

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
}