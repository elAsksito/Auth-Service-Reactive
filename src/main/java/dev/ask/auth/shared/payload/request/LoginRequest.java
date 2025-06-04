package dev.ask.auth.shared.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    @NotBlank(message = "El campo del correo electrónico es obligatorio")
    @Email(message = "Formato del correo electrónico no válido")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Formato del correo electrónico no válido")
    private String email;

    @NotBlank(message = "El campo contraseña es obligatorio")
    private String password;
}