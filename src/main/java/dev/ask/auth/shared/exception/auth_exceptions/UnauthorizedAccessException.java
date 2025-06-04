package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class UnauthorizedAccessException extends AuthenticationException {
    public UnauthorizedAccessException() {
        super(
                AuthErrorCodes.UNAUTHORIZED_ACCESS.getCode(),
                AuthErrorCodes.UNAUTHORIZED_ACCESS.getTitle(),
                AuthErrorCodes.UNAUTHORIZED_ACCESS.getMessage(),
                AuthErrorCodes.UNAUTHORIZED_ACCESS.getUri(),
                HttpStatus.FORBIDDEN);
    }
}