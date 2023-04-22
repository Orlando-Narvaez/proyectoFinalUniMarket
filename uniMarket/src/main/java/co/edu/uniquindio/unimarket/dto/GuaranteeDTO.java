package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class GuaranteeDTO
{
    @NotBlank(message = "La descripción no puede estar vacío")
    @NotNull(message = "La descripción no puede ser nulo")
    @Size(max = 500, message = "La descripción debe tener maximo 500 caracteres")
    private String describeGuarantee;

    @NotNull(message = "El mapa de imágenes no puede ser nulo")
    @Size(min = 1, message = "El producto debe tener al menos una imagen")
    private Map<String, String> images;

    @NotNull(message = "El id del producto no puede ser nulo")
    private int idProduct;

    @NotNull(message = "El id del usuario no puede ser nulo")
    private int idUser;
}