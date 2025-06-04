package dev.ask.auth.shared.utils.exception;

import lombok.Getter;

@Getter
public enum AuthErrorCodes {
        INVALID_CREDENTIALS(
                        "AUTH-001",
                        "https://docs.ask.com/errors/AUTH-001",
                        "Credenciales Inválidas",
                        "Las credenciales proporcionadas son incorrectas."),
        INVALID_PASSWORD(
                        "AUTH-002",
                        "https://docs.ask.com/errors/AUTH-002",
                        "Contraseña Inválida",
                        "La contraseña proporcionada es incorrecta."),
        ACCOUNT_LOCKED(
                        "AUTH-003",
                        "https://docs.ask.com/errors/AUTH-003",
                        "Cuenta Bloqueada",
                        "La cuenta de usuario ha sido bloqueada debido a múltiples intentos fallidos de inicio de sesión."),
        TOO_MANY_LOGIN_ATTEMPTS(
                        "AUTH-004",
                        "https://docs.ask.com/errors/AUTH-004",
                        "Demasiados Intentos de Inicio de Sesión",
                        "Has superado el número máximo de intentos de inicio de sesión. Por favor, inténtalo más tarde."),
        IP_BLOCKED(
                        "AUTH-005",
                        "https://docs.ask.com/errors/AUTH-005",
                        "IP Bloqueada",
                        "El acceso desde esta dirección IP ha sido bloqueado por razones de seguridad."),
        INVALID_JWT_TOKEN(
                        "AUTH-006",
                        "https://docs.ask.com/errors/AUTH-006",
                        "Token JWT Inválido",
                        "El token JWT proporcionado es inválido."),
        EXPIRED_JWT_TOKEN(
                        "AUTH-007",
                        "https://docs.ask.com/errors/AUTH-007",
                        "Token JWT Expirado",
                        "El token JWT ha expirado. Por favor, inicia sesión de nuevo."),
        NOT_AUTHENTICATED(
                        "AUTH-008",
                        "https://docs.ask.com/errors/AUTH-008",
                        "No Autenticado",
                        "No estás autenticado. Por favor, inicia sesión para continuar."),
        UNAUTHORIZED_ACCESS(
                        "AUTH-009",
                        "https://docs.ask.com/errors/AUTH-009",
                        "Acceso No Autorizado",
                        "No tienes permiso para acceder a este recurso."),
        RESOURCE_ACCESS_DENIED(
                        "AUTH-010",
                        "https://docs.ask.com/errors/AUTH-010",
                        "Acceso Denegado al Recurso",
                        "El acceso al recurso solicitado está denegado."),
        SESSION_EXPIRED(
                        "AUTH-011",
                        "https://docs.ask.com/errors/AUTH-011",
                        "Sesión Expirada",
                        "Tu sesión ha expirado. Por favor, inicia sesión de nuevo."),
        EMAIL_NOT_VERIFIED(
                        "AUTH-012",
                        "https://docs.ask.com/errors/AUTH-012",
                        "Correo No Verificado",
                        "Tu dirección de correo no ha sido verificada. Por favor, revisa tu bandeja de entrada."),
        USER_INACTIVE(
                        "AUTH-013",
                        "https://docs.ask.com/errors/AUTH-013",
                        "Usuario Inactivo",
                        "La cuenta de usuario está inactiva. Contacta con soporte para asistencia."),
        ACCOUNT_EXPIRED(
                        "AUTH-014",
                        "https://docs.ask.com/errors/AUTH-014",
                        "Cuenta Expirada",
                        "La cuenta de usuario ha expirado. Por favor, contacta al administrador.");

        private final String code;
        private final String uri;
        private final String title;
        private final String message;

        AuthErrorCodes(String code, String uri, String title, String message) {
                this.code = code;
                this.uri = uri;
                this.title = title;
                this.message = message;
        }
}