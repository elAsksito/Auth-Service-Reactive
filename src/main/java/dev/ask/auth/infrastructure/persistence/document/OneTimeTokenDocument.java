package dev.ask.auth.infrastructure.persistence.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import dev.ask.auth.shared.enums.OneTokenType;
import lombok.*;

@Document(collection = "one_time_tokens")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OneTimeTokenDocument {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("token_hash")
    private byte[] tokenHash;

    @Field("token_type")
    private OneTokenType tokenType;

    @Field("is_used")
    private boolean isUsed;

    @Field("used_at")
    private Instant usedAt;

    @Field("expires_at")
    private Instant expiresAt;

    @Field("created_at")
    private Instant createdAt;

    public void prePersist() {
        if (createdAt == null)
            createdAt = Instant.now();
    }
}