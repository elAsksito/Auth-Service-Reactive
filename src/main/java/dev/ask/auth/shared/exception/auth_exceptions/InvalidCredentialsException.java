package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class InvalidCredentialsException extends AuthenticationException {
    public InvalidCredentialsException() {
        super(
                AuthErrorCodes.INVALID_CREDENTIALS.getCode(),
                AuthErrorCodes.INVALID_CREDENTIALS.getTitle(),
                AuthErrorCodes.INVALID_CREDENTIALS.getMessage(),
                AuthErrorCodes.INVALID_CREDENTIALS.getUri(),
                HttpStatus.FORBIDDEN);
    }
}