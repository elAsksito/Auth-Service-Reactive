package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class AccountLockedException extends AuthenticationException {
    public AccountLockedException() {
        super(
                AuthErrorCodes.ACCOUNT_LOCKED.getCode(),
                AuthErrorCodes.ACCOUNT_LOCKED.getTitle(),
                AuthErrorCodes.ACCOUNT_LOCKED.getMessage(),
                AuthErrorCodes.ACCOUNT_LOCKED.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}