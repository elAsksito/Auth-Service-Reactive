package dev.ask.auth.shared.utils.exception;

import lombok.Getter;

@Getter
public enum ValidationErrorCodes {

    EMAIL_INVALID_FORMAT(
            "VAL-001",
            "https://docs.ask.com/errors/VAL-001",
            "Formato de Correo Inválido",
            "El correo electrónico proporcionado no tiene un formato válido.",
            "email"),

    EMAIL_REQUIRED(
            "VAL-002",
            "https://docs.ask.com/errors/VAL-002",
            "Correo Requerido",
            "El campo de correo electrónico es obligatorio.",
            "email"),

    PASSWORD_REQUIRED(
            "VAL-003",
            "https://docs.ask.com/errors/VAL-003",
            "Contraseña Requerida",
            "El campo de contraseña es obligatorio.",
            "password"),

    PASSWORD_TOO_SHORT(
            "VAL-004",
            "https://docs.ask.com/errors/VAL-004",
            "Contraseña Muy Corta",
            "La contraseña debe tener al menos 8 caracteres.",
            "password"),

    PASSWORD_TOO_WEAK(
            "VAL-005",
            "https://docs.ask.com/errors/VAL-005",
            "Contraseña Débil",
            "La contraseña debe incluir letras mayúsculas, minúsculas, números y símbolos.",
            "password"),

    PHONE_INVALID_FORMAT(
            "VAL-006",
            "https://docs.ask.com/errors/VAL-006",
            "Formato de Teléfono Inválido",
            "El número de teléfono proporcionado no tiene un formato válido.",
            "phone"),

    PHONE_REQUIRED(
            "VAL-007",
            "https://docs.ask.com/errors/VAL-007",
            "Teléfono Requerido",
            "El campo de número de teléfono es obligatorio.",
            "phone"),

    CODE_REQUIRED(
            "VAL-008",
            "https://docs.ask.com/errors/VAL-008",
            "Código Requerido",
            "El campo de código es obligatorio.",
            "code"),
    CODE_INVALID_FORMAT(
            "VAL-009",
            "https://docs.ask.com/errors/VAL-009",
            "Formato de Código Inválido",
            "El código proporcionado no tiene un formato válido.",
            "code");

    private final String code;
    private final String uri;
    private final String title;
    private final String message;
    private final String field;

    ValidationErrorCodes(String code, String uri, String title, String message, String field) {
        this.code = code;
        this.uri = uri;
        this.title = title;
        this.message = message;
        this.field = field;
    }
}