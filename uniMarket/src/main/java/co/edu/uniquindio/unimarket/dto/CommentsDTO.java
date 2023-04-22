package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CommentsDTO
{
    @NotBlank(message = "El comentario no puede estar vacío")
    @NotNull(message = "El comentario no puede ser nulo")
    @Size(max = 500, message = "El comentario debe tener maximo 500 caracteres")
    private String message;

    @NotNull(message = "El id del usuario no puede ser nulo")
    private int userCode;

    @NotNull(message = "El id del producto no puede ser nulo")
    private int productCode;
}