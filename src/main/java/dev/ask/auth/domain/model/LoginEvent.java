package dev.ask.auth.domain.model;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginEvent {
    private String id;
    private String userId;
    private String ipAddress;
    private String userAgent;
    private String deviceFingerprint;
    private Boolean success;
    private String failureReason;
    private String geoCountry;
    private String geoCity;
    private Instant timestamp;
}