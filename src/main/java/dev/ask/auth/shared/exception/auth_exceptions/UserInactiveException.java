package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class UserInactiveException extends AuthenticationException {
    public UserInactiveException() {
        super(
                AuthErrorCodes.USER_INACTIVE.getCode(),
                AuthErrorCodes.USER_INACTIVE.getTitle(),
                AuthErrorCodes.USER_INACTIVE.getMessage(),
                AuthErrorCodes.USER_INACTIVE.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}