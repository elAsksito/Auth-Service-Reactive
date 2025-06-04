package dev.ask.auth.shared.enums;

public enum SuspiciousActivityReason {
    MULTIPLE_FAILED_LOGINS,
    BRUTE_FORCE,
    SUSPICIOUS_LOCATION,
    IP_BLOCKED,
    DATA_EXFILTRATION,
    ACCOUNT_TAKEOVER,
    UNKNOWN;
}