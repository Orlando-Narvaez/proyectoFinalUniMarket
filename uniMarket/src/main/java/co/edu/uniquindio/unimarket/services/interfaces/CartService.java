package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.CartDTO;
import co.edu.uniquindio.unimarket.dto.CartGetDTO;
import co.edu.uniquindio.unimarket.dto.UserDTO;

import java.util.List;

public interface CartService
{
    int createCart(CartDTO cartDTO) throws Exception;

    int updateCart(int idCart, CartDTO cartDTO) throws Exception;

    int deleteCart(int idCart) throws Exception;

    List<CartDTO> listCart(int idCart) throws Exception;

    CartGetDTO getCart(int idCart) throws Exception;
}