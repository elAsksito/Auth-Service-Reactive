package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class InvalidJwtTokenException extends AuthenticationException {
    public InvalidJwtTokenException() {
        super(
                AuthErrorCodes.INVALID_JWT_TOKEN.getCode(),
                AuthErrorCodes.INVALID_JWT_TOKEN.getTitle(),
                AuthErrorCodes.INVALID_JWT_TOKEN.getMessage(),
                AuthErrorCodes.INVALID_JWT_TOKEN.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}