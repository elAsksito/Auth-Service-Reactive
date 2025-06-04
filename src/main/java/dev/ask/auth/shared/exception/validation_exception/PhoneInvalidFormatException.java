package dev.ask.auth.shared.exception.validation_exception;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.ValidationException;
import dev.ask.auth.shared.utils.exception.ValidationErrorCodes;

public class PhoneInvalidFormatException extends ValidationException {
    public PhoneInvalidFormatException() {
        super(
                ValidationErrorCodes.PHONE_INVALID_FORMAT.getCode(),
                ValidationErrorCodes.PHONE_INVALID_FORMAT.getTitle(),
                ValidationErrorCodes.PHONE_INVALID_FORMAT.getMessage(),
                ValidationErrorCodes.PHONE_INVALID_FORMAT.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.PHONE_INVALID_FORMAT.getField());
    }
}