package dev.ask.auth.shared.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class AuthenticationException extends BaseCustomException {
    public AuthenticationException(String code, String title, String description, String uri, HttpStatus status) {
        super(code, title, description, uri, status);
    }
}