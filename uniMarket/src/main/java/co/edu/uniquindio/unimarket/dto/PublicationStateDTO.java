package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PublicationStateDTO
{
    @NotNull(message = "La lista de estado no puede ser nula")
    private List<State> stateList;

    @NotBlank(message = "La razon no puede estar vacío")
    @NotNull(message = "La razon no puede ser nulo")
    @Size(max = 500, message = "La razon debe tener maximo 500 caracteres")
    private String reason;
}