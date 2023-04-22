package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.Categories;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDTO
{
    @NotNull(message = "El nombre del producto no puede ser nulo")
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(max = 100, message = "El nombre del producto no puede tener más de 100 caracteres")
    private String name;

    @NotNull(message = "La descripción del producto no puede ser nula")
    @NotBlank(message = "La descripción del producto no puede estar vacía")
    @Size(max = 500, message = "La descripción del producto no puede tener más de 500 caracteres")
    private String description;

    @NotNull(message = "El precio del producto no puede ser nulo")
    @Min(value = 1, message = "El número de unidades disponibles debe ser mayor o igual a 1")
    @Max(value = 100, message = "El número de unidades disponibles no puede ser mayor a 100")
    @PositiveOrZero(message = "El número de unidades disponibles debe ser mayor o igual a cero")
    private int units;

    @NotNull(message = "El precio del producto no puede ser nulo")
    @PositiveOrZero(message = "El precio del producto debe ser mayor o igual a cero")
    private float value;

    @NotNull(message = "El id del vendedor no puede ser nulo")
    private int sellerCode;

    @NotNull(message = "El mapa de imágenes no puede ser nulo")
    @Size(min = 1, message = "El producto debe tener al menos una imagen")
    private Map<String, String> imagenes;

    @NotNull(message = "La lista de categorías no puede ser nula")
    @Size(min = 1, message = "El producto debe tener al menos una categoría")
    private List<Categories> categories;
}