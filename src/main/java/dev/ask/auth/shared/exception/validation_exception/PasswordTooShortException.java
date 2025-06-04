package dev.ask.auth.shared.exception.validation_exception;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.ValidationException;
import dev.ask.auth.shared.utils.exception.ValidationErrorCodes;

public class PasswordTooShortException extends ValidationException{
    public PasswordTooShortException() {
        super(
                ValidationErrorCodes.PASSWORD_TOO_SHORT.getCode(),
                ValidationErrorCodes.PASSWORD_TOO_SHORT.getTitle(),
                ValidationErrorCodes.PASSWORD_TOO_SHORT.getMessage(),
                ValidationErrorCodes.PASSWORD_TOO_SHORT.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.PASSWORD_TOO_SHORT.getField());
    }
}