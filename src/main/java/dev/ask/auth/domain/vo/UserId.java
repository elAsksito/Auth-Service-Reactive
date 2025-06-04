package dev.ask.auth.domain.vo;

import dev.ask.auth.shared.exception.validation_exception.UserIdRequiredException;

public record UserId(String value) {
    public UserId {
        if (value == null || value.isBlank()) {
            throw new UserIdRequiredException();
        }
    }
}