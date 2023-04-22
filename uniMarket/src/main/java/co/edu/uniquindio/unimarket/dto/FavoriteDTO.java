package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoriteDTO
{
    @NotNull(message = "El id del producto no puede ser nulo")
    private int idUser;

    @NotNull(message = "El id del usuario no puede ser nulo")
    private int idProduct;
}