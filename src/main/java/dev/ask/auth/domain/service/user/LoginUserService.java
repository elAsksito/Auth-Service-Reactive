package dev.ask.auth.domain.service.user;

import dev.ask.auth.application.payload.request.LoginRequest;
import dev.ask.auth.application.payload.response.LoginResponse;
import reactor.core.publisher.Mono;

public interface LoginUserService {
    Mono<LoginResponse> loginUserWithEmailAndPassword(LoginRequest request, String ipAddress, String userAgent);
}