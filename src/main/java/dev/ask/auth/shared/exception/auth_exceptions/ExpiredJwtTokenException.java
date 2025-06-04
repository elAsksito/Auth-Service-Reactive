package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class ExpiredJwtTokenException extends AuthenticationException {
    public ExpiredJwtTokenException() {
        super(
                AuthErrorCodes.EXPIRED_JWT_TOKEN.getCode(),
                AuthErrorCodes.EXPIRED_JWT_TOKEN.getTitle(),
                AuthErrorCodes.EXPIRED_JWT_TOKEN.getMessage(),
                AuthErrorCodes.EXPIRED_JWT_TOKEN.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}