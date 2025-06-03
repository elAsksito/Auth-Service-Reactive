package dev.ask.auth.infrastructure.persistence.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;

@Document(collection = "login_events")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginEventDocument {
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

    @Field("success")
    private Boolean success;

    @Field("failure_reason")
    private String failureReason;

    @Field("geo_country")
    private String geoCountry;

    @Field("geo_city")
    private String geoCity;
    
    @Field("timestamp")
    private Instant timestamp;

    public void prePersist() {
        if (timestamp == null)
            timestamp = Instant.now();
    }
}