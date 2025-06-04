package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class IpBlockedException extends AuthenticationException {
    public IpBlockedException() {
        super(
                AuthErrorCodes.IP_BLOCKED.getCode(),
                AuthErrorCodes.IP_BLOCKED.getTitle(),
                AuthErrorCodes.IP_BLOCKED.getMessage(),
                AuthErrorCodes.IP_BLOCKED.getUri(),
                HttpStatus.FORBIDDEN);
    }
}