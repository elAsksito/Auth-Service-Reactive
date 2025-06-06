package dev.ask.auth.shared.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.ask.auth.shared.utils.exception.ApiError;
import dev.ask.auth.shared.utils.exception.ApiErrorBuilder;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public Mono<ResponseEntity<ApiError>> handleAuthenticationException(AuthenticationException ex) {
        ApiError error = ApiErrorBuilder.buildApiError(
                ex.getErrorCode(),
                ex.getErrorTitle(),
                ex.getErrorDescription(),
                ex.getErrorUri(),
                ex.getHttpStatus(),
                ex.getClass().getSimpleName(),
                null);

        return Mono.just(ResponseEntity.status(ex.getHttpStatus()).body(error));
    }

    @ExceptionHandler(ValidationException.class)
    public Mono<ResponseEntity<ApiError>> handleValidationException(ValidationException ex) {
        ApiError error = ApiErrorBuilder.buildApiError(
                ex.getErrorCode(),
                ex.getErrorTitle(),
                ex.getErrorDescription(),
                ex.getErrorUri(),
                ex.getHttpStatus(),
                ex.getClass().getSimpleName(),
                ex.getFieldErrors());
        return Mono.just(ResponseEntity.status(ex.getHttpStatus()).body(error));
    }
}