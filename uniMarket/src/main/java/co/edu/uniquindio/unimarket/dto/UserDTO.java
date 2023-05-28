package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter

public class UserDTO
{
    @NotBlank(message = "El nombre no puede estar vacío")
    @NotNull(message = "El nombre no puede ser nulo")
    @Length(max = 150, message = "El nombre debe tener máximo 100 caracteres")
    private String name;

    @NotBlank(message = "El correo no puede estar vacío")
    @NotNull(message = "El correo no puede ser nulo")
    @Length(max = 100, message = "El correo debe tener máximo 100 caracteres")
    @Email(message = "El correo no tiene un formato válido")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacío")
    @NotNull(message = "La contraseña no puede ser nulo")
    @Length(max = 50, message = "La contraseña debe tener máximo 50 caracteres")
    private String password;

    @NotBlank(message = "La direccion no puede estar vacía")
    @NotNull(message = "La direccion no puede ser nula")
    @Length(max = 100, message = "La dirección debe tener máximo 100 caracteres")
    private String address;

    @NotBlank(message = "El telefono no puede estar vacío")
    @NotNull(message = "El telefono no puede ser nulo")
    @Length(max = 12, message = "El teléfono debe tener máximo 12 caracteres")
    private String phoneNumber;
    private LocalDate birthDate;
}