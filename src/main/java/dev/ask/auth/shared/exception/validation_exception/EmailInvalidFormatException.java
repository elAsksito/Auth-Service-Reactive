package dev.ask.auth.shared.exception.validation_exception;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.ValidationException;
import dev.ask.auth.shared.utils.exception.ValidationErrorCodes;

public class EmailInvalidFormatException extends ValidationException {
    public EmailInvalidFormatException() {
        super(
                ValidationErrorCodes.EMAIL_INVALID_FORMAT.getCode(),
                ValidationErrorCodes.EMAIL_INVALID_FORMAT.getTitle(),
                ValidationErrorCodes.EMAIL_INVALID_FORMAT.getMessage(),
                ValidationErrorCodes.EMAIL_INVALID_FORMAT.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.EMAIL_INVALID_FORMAT.getField());
    }
}