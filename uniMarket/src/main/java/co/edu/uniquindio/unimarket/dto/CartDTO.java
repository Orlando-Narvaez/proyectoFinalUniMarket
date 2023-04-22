package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.PaymentMethod;
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
public class CartDTO
{
    @NotNull(message = "El id del usuario no puede ser nulo")
    private int idCartPerson;

    @NotBlank(message = "El metodo de pago no puede estar vacío")
    @NotNull(message = "El metodo de pago no puede ser nulo")
    private PaymentMethod PaymentMethod;

    @NotNull(message = "El detalle de la compra no puede ser nulo")
    @Size(min = 1, message = "Debe haber al menos un elemento en la lista")
    private List<DetailCartDTO> detailCartDTO;
}