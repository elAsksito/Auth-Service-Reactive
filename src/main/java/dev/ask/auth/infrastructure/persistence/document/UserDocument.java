package dev.ask.auth.infrastructure.persistence.document;

import dev.ask.auth.shared.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;

@Document(collection = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDocument {
    @Id
    private String id;

    @Field("email")
    private String email;

    @Field("password")
    private String password;

    @Field("is_email_verified")
    private boolean isEmailVerified;

    @Field("status")
    private Status status;

    @Field("failed_login_attempts")
    private int failedLoginAttempts;

    @Field("lock_until")
    private LocalDateTime lockUntil;

    @Field("two_fa_enabled")
    private boolean twoFaEnabled;

    @Field("two_fa_secret")
    private byte[] twoFaSecret;

    @Field("last_login")
    private LocalDateTime lastLogin;

    @Field("created_at")
    private LocalDateTime createdAt;

    @Field("updated_at")
    private LocalDateTime updatedAt;

    @Field("version")
    @Version
    private long version;

    @Field("password_last_changed")
    private LocalDateTime passwordLastChanged;

    @Field("must_change_password")
    private boolean mustChangePassword;

    @Field("roles")
    private List<String> roles;
    
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}