package dev.ask.auth.domain.vo;

import java.util.regex.Pattern;

import dev.ask.auth.shared.exception.validation_exception.EmailInvalidFormatException;
import dev.ask.auth.shared.exception.validation_exception.EmailRequiredException;

public record Email(String value) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public Email {
        if (value == null || value.isBlank()) {
            throw new EmailRequiredException();
        }

        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new EmailInvalidFormatException();
        }
    }

    @Override
    public String toString() {
        return value;
    }
}