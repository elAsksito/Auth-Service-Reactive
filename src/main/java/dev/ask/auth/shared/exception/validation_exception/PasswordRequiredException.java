package dev.ask.auth.shared.exception.validation_exception;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.ValidationException;
import dev.ask.auth.shared.utils.exception.ValidationErrorCodes;

public class PasswordRequiredException extends ValidationException {
    public PasswordRequiredException() {
        super(
                ValidationErrorCodes.PASSWORD_REQUIRED.getCode(),
                ValidationErrorCodes.PASSWORD_REQUIRED.getTitle(),
                ValidationErrorCodes.PASSWORD_REQUIRED.getMessage(),
                ValidationErrorCodes.PASSWORD_REQUIRED.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.PASSWORD_REQUIRED.getField());
    }
}