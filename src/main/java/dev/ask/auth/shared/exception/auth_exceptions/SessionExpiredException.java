package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class SessionExpiredException extends AuthenticationException {
    public SessionExpiredException() {
        super(
                AuthErrorCodes.SESSION_EXPIRED.getCode(),
                AuthErrorCodes.SESSION_EXPIRED.getTitle(),
                AuthErrorCodes.SESSION_EXPIRED.getMessage(),
                AuthErrorCodes.SESSION_EXPIRED.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}