package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.DetailCart;
import co.edu.uniquindio.unimarket.model.PaymentMethod;
import co.edu.uniquindio.unimarket.model.StateCart;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CartGetDTO
{
    private int idCart;

    private LocalDateTime buyDate;

    private int idUser;

    private double totalValue;

    private PaymentMethod paymentMethod;

    private StateCart stateCart;
}