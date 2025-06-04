package dev.ask.auth.shared.exception.auth_exceptions;

import org.springframework.http.HttpStatus;

import dev.ask.auth.shared.exception.AuthenticationException;
import dev.ask.auth.shared.utils.exception.AuthErrorCodes;

public class ResourceAccessDeniedException extends AuthenticationException {
    public ResourceAccessDeniedException() {
        super(
                AuthErrorCodes.RESOURCE_ACCESS_DENIED.getCode(),
                AuthErrorCodes.RESOURCE_ACCESS_DENIED.getTitle(),
                AuthErrorCodes.RESOURCE_ACCESS_DENIED.getMessage(),
                AuthErrorCodes.RESOURCE_ACCESS_DENIED.getUri(),
                HttpStatus.FORBIDDEN);
    }
}