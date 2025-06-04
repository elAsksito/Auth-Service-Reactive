package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class EmailNotVerifiedException extends AuthenticationException {
    public EmailNotVerifiedException() {
        super(
                AuthErrorCodes.EMAIL_NOT_VERIFIED.getCode(),
                AuthErrorCodes.EMAIL_NOT_VERIFIED.getTitle(),
                AuthErrorCodes.EMAIL_NOT_VERIFIED.getMessage(),
                AuthErrorCodes.EMAIL_NOT_VERIFIED.getUri(),
                HttpStatus.UNAUTHORIZED);
    }
}