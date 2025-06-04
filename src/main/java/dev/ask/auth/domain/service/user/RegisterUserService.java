package dev.ask.auth.domain.service.user;

import dev.ask.auth.domain.model.User;
import dev.ask.auth.shared.payload.request.LoginRequest;
import reactor.core.publisher.Mono;

public interface RegisterUserService {
    Mono<User> createUserWithEmailAndPassword(LoginRequest request, String ipAddress, String userAgent);
}
