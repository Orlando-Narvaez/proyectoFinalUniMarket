package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.DetailCart;
import co.edu.uniquindio.unimarket.model.PaymentMethod;
import java.time.LocalDateTime;
import java.util.List;

public class CartGetDTO
{
    private int idCart;

    private LocalDateTime startDate;

    private LocalDateTime buyDate;

    private String idUser;

    private float totalValue;

    private PaymentMethod paymentMethod;

    private List<DetailCart> detailCartList;
}