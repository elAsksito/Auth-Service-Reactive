package dev.ask.auth.shared.mapper;

import dev.ask.auth.shared.enums.Severity;
import dev.ask.auth.shared.enums.SuspiciousActivityReason;

public class SeverityMapper {
    public static Severity determineSeverity(SuspiciousActivityReason reason) {
        return switch (reason) {
            case MULTIPLE_FAILED_LOGINS, BRUTE_FORCE -> Severity.HIGH;
            case SUSPICIOUS_LOCATION, IP_BLOCKED -> Severity.MEDIUM;
            case DATA_EXFILTRATION, ACCOUNT_TAKEOVER -> Severity.CRITICAL;
            default -> Severity.LOW;
        };
    }
}
