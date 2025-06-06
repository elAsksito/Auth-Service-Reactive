package dev.ask.auth.infrastructure.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ask.auth.application.payload.request.LoginRequest;
import dev.ask.auth.application.payload.response.LoginResponse;
import dev.ask.auth.domain.service.user.LoginUserService;
import dev.ask.auth.infrastructure.api.utils.ExtractClientIp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUserService loginUserService;

    @PostMapping("/login")
    public Mono<ResponseEntity<LoginResponse>> singInWithEmailAndPassword(
            @Valid @RequestBody Mono<LoginRequest> request,
            ServerHttpRequest httpRequest) {

        String ipAddress = ExtractClientIp.extractClientIp(httpRequest);
        String userAgent = httpRequest.getHeaders().getFirst("User-Agent");

        return request
                .flatMap(req -> loginUserService
                        .loginUserWithEmailAndPassword(req, ipAddress, userAgent)
                        .map(response -> ResponseEntity.ok(response)));
    }

}