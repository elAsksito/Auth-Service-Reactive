package dev.ask.auth.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BlockTime {
    NONE(0),
    MINUTE(60),
    MINUTES_5(5 * 60),
    DAY(24 * 60 * 60),
    WEEK(7 * 24 * 60 * 60),
    MONTH(30 * 24 * 60 * 60),
    YEAR(365 * 24 * 60 * 60);

    private final int seconds;
}