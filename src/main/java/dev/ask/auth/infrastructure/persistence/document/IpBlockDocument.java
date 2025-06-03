package dev.ask.auth.infrastructure.persistence.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;

@Document(collection = "ip_blocks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IpBlockDocument {
    @Id
    @Field("ip_address")
    private String ipAddress;

    @Field("blocked_until")
    private Instant blockedUntil;

    @Field("reason")
    private String reason;

    @Field("created_at")
    private Instant createdAt;

    public void prePersist() {
        if (createdAt == null)
            createdAt = Instant.now();
    }
}