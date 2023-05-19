package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.CartDTO;
import co.edu.uniquindio.unimarket.dto.CartGetDTO;
import co.edu.uniquindio.unimarket.dto.UserDTO;
import co.edu.uniquindio.unimarket.model.Cart;
import co.edu.uniquindio.unimarket.model.State;
import co.edu.uniquindio.unimarket.model.StateCart;

import java.util.List;

public interface CartService
{
    int createCart(CartDTO cartDTO) throws Exception;
    CartGetDTO getCart(int idCart) throws Exception;
    Cart getCartBD(int idCart) throws Exception;
    List<CartGetDTO> listCartForUser(int idCard) throws Exception;
    List<CartGetDTO> listCartForState(StateCart stateCart) throws Exception;
}