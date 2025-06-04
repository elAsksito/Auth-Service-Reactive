package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class AccountExpiredException extends AuthenticationException {
    public AccountExpiredException() {
        super(
                AuthErrorCodes.ACCOUNT_EXPIRED.getCode(),
                AuthErrorCodes.ACCOUNT_EXPIRED.getTitle(),
                AuthErrorCodes.ACCOUNT_EXPIRED.getMessage(),
                AuthErrorCodes.ACCOUNT_EXPIRED.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}