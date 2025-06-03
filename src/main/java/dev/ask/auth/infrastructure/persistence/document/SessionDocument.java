package dev.ask.auth.infrastructure.persistence.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;

@Document(collection = "sessions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionDocument {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("session_token_hash")
    private byte[] sessionTokenHash;

    @Field("user_agent")
    private String userAgent;

    @Field("ip_address")
    private String ipAddress;

    @Field("created_at")
    private Instant createdAt;

    @Field("expires_at")
    private Instant expiresAt;

    @Field("is_revoked")
    private boolean isRevoked;

    @Field("revoked_at")
    private Instant revokedAt;
    
    @Field("last_activity")
    private Instant lastActivity;

    public void prePersist() {
        if (createdAt == null)
            createdAt = Instant.now();
    }
}