package dev.ask.auth.domain.vo;

import dev.ask.auth.shared.exception.validation_exception.PhoneInvalidFormatException;
import dev.ask.auth.shared.exception.validation_exception.PhoneRequiredException;

public record Phone(String value) {
    private static final String PHONE_PATTERN = "^[0-9]{9}$";

    public Phone {
        if (value == null || value.isBlank()) {
            throw new PhoneRequiredException();
        }
        if (!value.matches(PHONE_PATTERN)) {
            throw new PhoneInvalidFormatException();
        }
    }
}