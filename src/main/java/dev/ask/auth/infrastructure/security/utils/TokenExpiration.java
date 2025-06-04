package dev.ask.auth.infrastructure.security.utils;

import lombok.Getter;

@Getter
public enum TokenExpiration {

    ACCESS(86400),
    REFRESH(604800),
    SESSION(604800);

    private final long seconds;

    TokenExpiration(long seconds) {
        this.seconds = seconds;
    }

    public long getSeconds() {
        return seconds;
    }
}