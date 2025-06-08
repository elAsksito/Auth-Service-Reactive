package dev.ask.auth.domain.service.reset_code;

import reactor.core.publisher.Mono;

public interface VerifyCodeService {
    Mono<Boolean> verifyCode(String email, String code);
}