package dev.ask.auth.application.payload.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResetPasswordRequest {
    private String email;
}