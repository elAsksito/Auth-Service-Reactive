package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class UserAlreadyExistException extends AuthenticationException {
    public UserAlreadyExistException() {
        super(
                AuthErrorCodes.USER_ALREADY_EXISTS.getCode(),
                AuthErrorCodes.USER_ALREADY_EXISTS.getTitle(),
                AuthErrorCodes.USER_ALREADY_EXISTS.getMessage(),
                AuthErrorCodes.USER_ALREADY_EXISTS.getUri(),
                HttpStatus.BAD_REQUEST);
    }
}