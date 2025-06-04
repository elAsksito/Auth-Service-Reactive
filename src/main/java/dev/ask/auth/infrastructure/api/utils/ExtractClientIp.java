package dev.ask.auth.infrastructure.api.utils;

import org.springframework.http.server.ServerHttpRequest;

public class ExtractClientIp {
    public static String extractClientIp(ServerHttpRequest request) {
        String xForwardedFor = request.getHeaders().getFirst("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0];
        }
        return request.getRemoteAddress() != null
                ? request.getRemoteAddress().getAddress().getHostAddress()
                : "unknown";
    }
}
