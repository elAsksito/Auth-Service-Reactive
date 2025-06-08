package dev.ask.auth.infrastructure.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ask.auth.application.payload.request.ResetPasswordRequest;
import dev.ask.auth.domain.service.user.ResetPasswordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class ResetPasswordController {
    private final ResetPasswordService resetPasswordService;

    @PostMapping("/reset-password")
    public Mono<ResponseEntity<String>> resetPasswordAndSendRandom(
            @RequestBody @Valid ResetPasswordRequest request) {
        return resetPasswordService.resetAndSendNewPassword(request.getEmail()).map(a -> {
            return ResponseEntity.ok("Se ha enviado un correo con la nueva contraseña");
        });
    }
}