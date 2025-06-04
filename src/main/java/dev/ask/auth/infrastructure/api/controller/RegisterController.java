package dev.ask.auth.infrastructure.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ask.auth.application.payload.request.RegisterRequest;
import dev.ask.auth.domain.service.user.RegisterUserService;
import dev.ask.auth.infrastructure.api.utils.ExtractClientIp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterUserService registerUserService;

    @PostMapping("/register")
    Mono<ResponseEntity<?>> createUserWithEmailAndPassword(@Valid @RequestBody Mono<RegisterRequest> request,
            ServerHttpRequest httpRequest) {
        String ipAddress = ExtractClientIp.extractClientIp(httpRequest);
        String userAgent = httpRequest.getHeaders().getFirst("User-Agent");

        return request.flatMap(req -> {

        return registerUserService.createUserWithEmailAndPassword(req, ipAddress, userAgent)
            .map(user -> ResponseEntity.ok("Registro exitoso"));
    });
    }
}