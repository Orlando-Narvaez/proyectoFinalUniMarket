package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SessionsDTO
{
    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email no tiene un formato válido")
    private String email;

    @NotNull(message = "La contraseña no puede ser nula")
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;
}