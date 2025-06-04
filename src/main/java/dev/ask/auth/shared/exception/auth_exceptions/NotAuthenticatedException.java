package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class NotAuthenticatedException extends AuthenticationException {
    public NotAuthenticatedException() {
        super(
                AuthErrorCodes.NOT_AUTHENTICATED.getCode(),
                AuthErrorCodes.NOT_AUTHENTICATED.getTitle(),
                AuthErrorCodes.NOT_AUTHENTICATED.getMessage(),
                AuthErrorCodes.NOT_AUTHENTICATED.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}