package dev.ask.auth.domain.service.user;

import dev.ask.auth.application.payload.request.RegisterRequest;
import dev.ask.auth.domain.model.User;
import reactor.core.publisher.Mono;

public interface RegisterUserService {
    Mono<User> createUserWithEmailAndPassword(RegisterRequest request, String ipAddress, String userAgent);
}