package dev.ask.auth.shared.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.ask.auth.shared.utils.exception.ApiError;
import dev.ask.auth.shared.utils.exception.ApiErrorBuilder;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public Mono<ApiError> handleAuthenticationException(AuthenticationException ex) {
        return Mono.just(
                ApiErrorBuilder.buildApiError(
                        ex.getErrorCode(),
                        ex.getErrorTitle(),
                        ex.getErrorDescription(),
                        ex.getErrorUri(),
                        ex.getHttpStatus(),
                        ex.getClass().getSimpleName(),
                        null));
    }

    @ExceptionHandler(ValidationException.class)
    public Mono<ApiError> handleValidationException(ValidationException ex) {
        return Mono.just(ApiErrorBuilder.buildApiError(
                ex.getErrorCode(),
                ex.getErrorTitle(),
                ex.getErrorDescription(),
                ex.getErrorUri(),
                ex.getHttpStatus(),
                ex.getClass().getSimpleName(),
                ex.getFieldErrors()));
    }
}