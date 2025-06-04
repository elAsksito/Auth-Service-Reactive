package dev.ask.auth.domain.vo;

import dev.ask.auth.shared.exception.validation_exception.PasswordRequiredException;
import dev.ask.auth.shared.exception.validation_exception.PasswordTooShortException;
import dev.ask.auth.shared.exception.validation_exception.PasswordTooWeakException;

public record Password(String value) {
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

    public Password {
        if (value == null || value.isBlank()) {
            throw new PasswordRequiredException();
        }
        if (value.length() < 8) {
            throw new PasswordTooShortException();
        }
        if (!value.matches(PASSWORD_PATTERN)) {
            throw new PasswordTooWeakException();
        }
    }

    @Override
    public String toString() {
        return value;
    }
}