package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.CartDTO;
import co.edu.uniquindio.unimarket.dto.CartGetDTO;
import java.util.List;

public interface CartService
{
    int createCart(CartDTO cartDTO) throws Exception;

    List<CartDTO> listCart(int userCode) throws Exception;

    CartGetDTO getCart(int idCart) throws Exception;
}