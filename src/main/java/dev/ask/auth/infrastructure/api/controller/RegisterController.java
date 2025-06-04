package dev.ask.auth.infrastructure.api.controller;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ask.auth.domain.model.User;
import dev.ask.auth.domain.service.user.RegisterUserService;
import dev.ask.auth.infrastructure.api.utils.ExtractClientIp;
import dev.ask.auth.shared.payload.request.LoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterUserService registerUserService;

    @PostMapping("/register")
    Mono<User> createUserWithEmailAndPassword(@Valid @RequestBody LoginRequest request,
            ServerHttpRequest httpRequest) {
        String ipAddress = ExtractClientIp.extractClientIp(httpRequest);
        String userAgent = httpRequest.getHeaders().getFirst("User-Agent");

        return registerUserService.createUserWithEmailAndPassword(request, ipAddress, userAgent)
                .switchIfEmpty(Mono.error(new RuntimeException("Failed to create user")));
    }
}