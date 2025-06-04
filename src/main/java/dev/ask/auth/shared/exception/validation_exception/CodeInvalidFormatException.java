package dev.ask.auth.shared.exception.validation_exception;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.ValidationException;
import dev.ask.auth.shared.utils.exception.ValidationErrorCodes;

public class CodeInvalidFormatException extends ValidationException {
    public CodeInvalidFormatException() {
        super(
                ValidationErrorCodes.CODE_INVALID_FORMAT.getCode(),
                ValidationErrorCodes.CODE_INVALID_FORMAT.getTitle(),
                ValidationErrorCodes.CODE_INVALID_FORMAT.getMessage(),
                ValidationErrorCodes.CODE_INVALID_FORMAT.getUri(),
                HttpStatus.BAD_REQUEST,
                ValidationErrorCodes.CODE_INVALID_FORMAT.getField());
    }
}