package dev.ask.auth.infrastructure.persistence.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import dev.ask.auth.shared.enums.TokenType;
import lombok.*;

@Document(collection = "tokens")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDocument {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("token_hash")
    private byte[] tokenHash;

    @Field("token_type")
    private TokenType tokenType;

    @Field("user_agent")
    private String userAgent;

    @Field("ip_address")
    private String ipAddress;

    @Field("is_revoked")
    private boolean isRevoked;

    @Field("revoked_at")
    private Instant revokedAt;

    @Field("parent_token_id")
    private String parentTokenId;

    @Field("expires_at")
    private Instant expiresAt;
    
    @Field("created_at")
    private Instant createdAt;

    public void prePersist() {
        createdAt = Instant.now();
    }
}