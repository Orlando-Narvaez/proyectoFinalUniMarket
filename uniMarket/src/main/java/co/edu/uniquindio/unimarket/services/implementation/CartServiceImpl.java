package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.CartDTO;
import co.edu.uniquindio.unimarket.dto.CartGetDTO;
import co.edu.uniquindio.unimarket.model.Cart;
import co.edu.uniquindio.unimarket.model.StateCart;
import co.edu.uniquindio.unimarket.repository.CartRepo;
import co.edu.uniquindio.unimarket.services.interfaces.CartService;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService
{
    private final CartRepo cartRepo;
    private final 
    private final UserService userService;
    @Override
    public int createCart(CartDTO cartDTO) throws Exception
    {
        return 0;
    }

    @Override
    public CartGetDTO getCart(int idCart) throws Exception {
        return null;
    }

    @Override
    public Cart getCartBD(int idCart) throws Exception {
        return null;
    }

    @Override
    public List<CartGetDTO> listCartForUser(int idCard) throws Exception {
        return null;
    }

    @Override
    public List<CartGetDTO> listCartForState(StateCart stateCart) throws Exception {
        return null;
    }
}