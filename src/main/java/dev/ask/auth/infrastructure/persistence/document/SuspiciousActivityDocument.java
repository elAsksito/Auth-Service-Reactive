package dev.ask.auth.infrastructure.persistence.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import dev.ask.auth.shared.enums.Severity;
import dev.ask.auth.shared.enums.SuspiciousActivityReason;
import lombok.*;

@Document(collection = "suspicious_activity")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousActivityDocument {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("ip_address")
    private String ipAddress;

    @Field("user_agent")
    private String userAgent;

    @Field("device_fingerprint")
    private String deviceFingerprint;

    @Field("reason")
    private SuspiciousActivityReason reason;

    @Field("severity")
    private Severity severity;

    @Field("details")
    private String details;

    @Field("timestamp")
    private Instant timestamp;

    public void prePersist() {
        if (timestamp == null)
            timestamp = Instant.now();
    }
}