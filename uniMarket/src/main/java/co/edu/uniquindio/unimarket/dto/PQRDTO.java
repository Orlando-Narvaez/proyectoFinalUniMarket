package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PQRDTO
{
    @NotBlank(message = "La descripción no puede estar vacío")
    @NotNull(message = "La descripción no puede ser nulo")
    @Size(max = 500, message = "La descripción debe tener maximo 500 caracteres")
    private String description;

    @NotNull(message = "El id del carrito no puede ser nulo")
    private int idCartUser;
}