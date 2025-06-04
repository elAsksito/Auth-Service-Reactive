package dev.ask.auth.shared.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public abstract class BaseCustomException extends RuntimeException {
    private final String errorCode;
    private final String errorTitle;
    private final String errorDescription;
    private final String errorUri;
    private final HttpStatus httpStatus;

    public BaseCustomException(String code, String title, String description, String uri, HttpStatus status) {
        super(description);
        this.errorCode = code;
        this.errorTitle = title;
        this.errorDescription = description;
        this.errorUri = uri;
        this.httpStatus = status;
    }
}