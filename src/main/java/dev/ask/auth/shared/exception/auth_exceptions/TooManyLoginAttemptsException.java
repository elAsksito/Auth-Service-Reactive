package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class TooManyLoginAttemptsException extends AuthenticationException {
    public TooManyLoginAttemptsException() {
        super(
                AuthErrorCodes.TOO_MANY_LOGIN_ATTEMPTS.getCode(),
                AuthErrorCodes.TOO_MANY_LOGIN_ATTEMPTS.getTitle(),
                AuthErrorCodes.TOO_MANY_LOGIN_ATTEMPTS.getMessage(),
                AuthErrorCodes.TOO_MANY_LOGIN_ATTEMPTS.getUri(),
                HttpStatus.TOO_MANY_REQUESTS);
    }
}