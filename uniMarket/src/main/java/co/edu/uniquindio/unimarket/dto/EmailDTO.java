package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmailDTO
{
    @NotNull(message = "El asunto no puede ser nulo")
    @NotBlank(message = "El asunto no puede estar vacío")
    @Size(max = 50, message = "El asunto debe tener entre 5 y 50 caracteres")
    private String mailSubject;

    @NotNull(message = "El cuerpo no puede ser nulo")
    @NotBlank(message = "El cuerpo no puede estar vacío")
    @Size(max = 500, message = "El cuerpo debe tener entre 5 y 500 caracteres")
    private String body;

    @NotNull(message = "El destinatario no puede ser nulo")
    @NotBlank(message = "El destinatario no puede estar vacío")
    @Size(max = 50, message = "El destinatario debe tener entre 5 y 50 caracteres")
    private String addressee;
}