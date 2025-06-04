package dev.ask.auth.domain.model;

import dev.ask.auth.shared.enums.Status;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String id;
    private String email;
    private String password;
    private boolean isEmailVerified;
    private Status status;
    private int failedLoginAttempts;
    private LocalDateTime lockUntil;
    private boolean twoFaEnabled;
    private byte[] twoFaSecret;
    private LocalDateTime lastLogin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long version;
    private LocalDateTime passwordLastChanged;
    private boolean mustChangePassword;
    private String[] roles;
}