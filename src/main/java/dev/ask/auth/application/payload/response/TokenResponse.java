package dev.ask.auth.application.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
}