package dev.ask.auth.shared.exception.validation_exception;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.ValidationException;
import dev.ask.auth.shared.utils.exception.ValidationErrorCodes;

public class EmailRequiredException extends ValidationException{
    public EmailRequiredException() {
        super(
                ValidationErrorCodes.EMAIL_REQUIRED.getCode(),
                ValidationErrorCodes.EMAIL_REQUIRED.getTitle(),
                ValidationErrorCodes.EMAIL_REQUIRED.getMessage(),
                ValidationErrorCodes.EMAIL_REQUIRED.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.EMAIL_REQUIRED.getField());
    }
}