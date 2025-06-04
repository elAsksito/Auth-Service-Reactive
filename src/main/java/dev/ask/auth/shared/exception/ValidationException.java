package dev.ask.auth.shared.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ValidationException extends BaseCustomException {
    private final String fieldErrors;

    public ValidationException(String code, String title, String description, String uri, HttpStatus status, String fieldErrors) {
        super(code, title, description, uri, status);
        this.fieldErrors = fieldErrors;
    }
}