package dev.ask.auth.shared.exception.validation_exception;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.ValidationException;
import dev.ask.auth.shared.utils.exception.ValidationErrorCodes;

public class PhoneRequiredException extends ValidationException {
    public PhoneRequiredException() {
        super(
                ValidationErrorCodes.PHONE_REQUIRED.getCode(),
                ValidationErrorCodes.PHONE_REQUIRED.getTitle(),
                ValidationErrorCodes.PHONE_REQUIRED.getMessage(),
                ValidationErrorCodes.PHONE_REQUIRED.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.PHONE_REQUIRED.getField());
    }
}