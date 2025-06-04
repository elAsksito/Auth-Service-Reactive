package dev.ask.auth.domain.service.user;

import dev.ask.auth.application.payload.request.LoginRequest;
import dev.ask.auth.domain.model.User;
import reactor.core.publisher.Mono;

public interface LoginUserService {
    Mono<User> loginUserWithEmailAndPassword(LoginRequest request, String ipAddress, String userAgent);
}