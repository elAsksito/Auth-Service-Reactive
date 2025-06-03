package dev.ask.auth.infrastructure.persistence.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;

@Document(collection = "password_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordHistoryDocument {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("password_hash")
    private String passwordHash;

    @Field("changed_at")
    private Instant changedAt;

    public void prePersist() {
        if (changedAt == null)
            changedAt = Instant.now();
    }
}