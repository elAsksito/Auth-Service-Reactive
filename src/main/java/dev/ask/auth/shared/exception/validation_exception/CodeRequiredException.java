package dev.ask.auth.shared.exception.validation_exception;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.ValidationException;
import dev.ask.auth.shared.utils.exception.ValidationErrorCodes;

public class CodeRequiredException extends ValidationException {
    public CodeRequiredException() {
        super(
                ValidationErrorCodes.CODE_REQUIRED.getCode(),
                ValidationErrorCodes.CODE_REQUIRED.getTitle(),
                ValidationErrorCodes.CODE_REQUIRED.getMessage(),
                ValidationErrorCodes.CODE_REQUIRED.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.CODE_REQUIRED.getField());
    }
}