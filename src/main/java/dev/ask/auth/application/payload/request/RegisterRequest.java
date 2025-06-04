package dev.ask.auth.application.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    String email;
    String password;
}