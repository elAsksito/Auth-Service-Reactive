package dev.ask.auth.application.service.token;

import dev.ask.auth.domain.repository.TokenRepository;
import dev.ask.auth.domain.service.token.ExistsActiveTokenForDeviceService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ExistsActiveTokenForDeviceServiceImpl implements ExistsActiveTokenForDeviceService {

    private final TokenRepository tokenRepository;

    @Override
    public Mono<Boolean> existsActiveTokenForDevice(String userId, String ipAddress, String userAgent) {
        return tokenRepository.existsActiveTokenForDevice(userId, ipAddress, userAgent);
    }
}