package dev.ask.auth.application.service.session;

import dev.ask.auth.application.payload.response.TokenResponse;
import dev.ask.auth.domain.service.session.IsSessionValidService;
import dev.ask.auth.domain.service.session.RevokeSessionService;
import dev.ask.auth.domain.service.session.RotateSessionService;
import dev.ask.auth.domain.service.token.SaveTokenService;
import dev.ask.auth.infrastructure.security.jwt.JwtService;
import dev.ask.auth.shared.exception.auth_exceptions.ExpiredJwtTokenException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RotateSessionServiceImpl implements RotateSessionService {

    private final JwtService jwtService;
    private final RevokeSessionService revokeSessionService;
    private final SaveTokenService saveTokenService;
    private final IsSessionValidService isSessionValidService;

    @Override
    public Mono<TokenResponse> rotateSession(String oldRefreshToken, String ipAddress, String userAgent) {
        return Mono.fromCallable(() -> jwtService.extractAllClaims(oldRefreshToken))
                .flatMap(claims -> {
                    String userId = claims.getSubject();
                    String sessionId = claims.get("sessionId", String.class);

                    return isSessionValidService.isSessionValid(userId, sessionId)
                            .flatMap(isValid -> {
                                if (!isValid) {
                                    return Mono.error(new ExpiredJwtTokenException());
                                }

                                return revokeSessionService.revokeSession(userId, ipAddress, userAgent)
                                        .then(saveTokenService.saveToken(userId, ipAddress, userAgent));
                            });
                });
    }
}