package dev.ask.auth.infrastructure.persistence.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;

@Document(collection = "failed_login_attempts_ip")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FailedLoginAttemptsIpDocument {
    @Id
    @Field("ip_address")
    private String ipAddress;

    @Field("attempts")
    private int attempts;

    @Field("last_attempt")
    private Instant lastAttempt;

    @Field("blocked_until")
    private Instant blockedUntil;

    public void prePersist() {
        if (lastAttempt == null)
            lastAttempt = Instant.now();
    }
}
