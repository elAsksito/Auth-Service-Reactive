package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class InvalidPasswordException extends AuthenticationException {
    public InvalidPasswordException() {
        super(
                AuthErrorCodes.INVALID_PASSWORD.getCode(),
                AuthErrorCodes.INVALID_PASSWORD.getTitle(),
                AuthErrorCodes.INVALID_PASSWORD.getMessage(),
                AuthErrorCodes.INVALID_PASSWORD.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}