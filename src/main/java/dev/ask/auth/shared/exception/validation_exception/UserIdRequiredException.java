package dev.ask.auth.shared.exception.validation_exception;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.ValidationException;
import dev.ask.auth.shared.utils.exception.ValidationErrorCodes;

public class UserIdRequiredException extends ValidationException {
    public UserIdRequiredException() {
        super(
                ValidationErrorCodes.USER_ID_REQUIRED.getCode(),
                ValidationErrorCodes.USER_ID_REQUIRED.getTitle(),
                ValidationErrorCodes.USER_ID_REQUIRED.getMessage(),
                ValidationErrorCodes.USER_ID_REQUIRED.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.USER_ID_REQUIRED.getField());
    }
}