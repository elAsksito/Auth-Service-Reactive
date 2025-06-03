package dev.ask.auth.infrastructure.persistence.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import dev.ask.auth.shared.enums.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "audit_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogDocument {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("action")
    private Action action;

    @Field("metadata")
    private String metadata;

    @Field("ip_address")
    private String ipAddress;

    @Field("user_agent")
    private String userAgent;
    
    @Field("created_at")
    private Instant createdAt;

    public void prePersist() {
        if (createdAt == null)
            createdAt = Instant.now();
    }
}