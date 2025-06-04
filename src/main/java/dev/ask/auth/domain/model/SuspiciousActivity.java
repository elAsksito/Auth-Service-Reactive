package dev.ask.auth.domain.model;

import java.time.Instant;

import dev.ask.auth.shared.enums.Severity;
import dev.ask.auth.shared.enums.SuspiciousActivityReason;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuspiciousActivity {
    private String id;
    private String userId;
    private String ipAddress;
    private String userAgent;
    private String deviceFingerprint;
    private SuspiciousActivityReason reason;
    private Severity severity;
    private String details;
    private Instant timestamp;
}