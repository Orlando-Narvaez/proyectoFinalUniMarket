package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.PaymentMethod;

import java.util.List;

public class CartDTO
{
    private int idCart;

    private PaymentMethod PaymentMethod;

    private List<DetailCartDTO> detailCartDTO;
}