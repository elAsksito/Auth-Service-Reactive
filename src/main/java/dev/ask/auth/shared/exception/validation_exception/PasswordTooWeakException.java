package dev.ask.auth.shared.exception.validation_exception;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.ValidationException;
import dev.ask.auth.shared.utils.exception.ValidationErrorCodes;

public class PasswordTooWeakException extends ValidationException {
    public PasswordTooWeakException() {
        super(
                ValidationErrorCodes.PASSWORD_TOO_WEAK.getCode(),
                ValidationErrorCodes.PASSWORD_TOO_WEAK.getTitle(),
                ValidationErrorCodes.PASSWORD_TOO_WEAK.getMessage(),
                ValidationErrorCodes.PASSWORD_TOO_WEAK.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.PASSWORD_TOO_WEAK.getField());
    }
}