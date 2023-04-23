package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.CartDTO;
import co.edu.uniquindio.unimarket.dto.CartGetDTO;
import co.edu.uniquindio.unimarket.model.Cart;
import co.edu.uniquindio.unimarket.repository.CartRepo;
import co.edu.uniquindio.unimarket.services.interfaces.CartService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CartServiceImpl implements CartService
{
    private  final CartRepo cartRepo;
    @Override
    public int createCart(CartDTO cartDTO) throws Exception
    {
        Cart cart = new Cart();
        return cartRepo.save(cart).getIdCart();
    }

    @Override
    public int updateCart(int idCart, CartDTO cartDTO) throws Exception {
        Cart cart = new Cart();
        return 0;
    }

    @Override
    public int deleteCart(int idCart) throws Exception {
        return 0;
    }

    @Override
    public List<CartDTO> listCart(int idCart) throws Exception {
        Optional<Cart> cart = cartRepo.findById(idCart);
        return null;
    }

    @Override
    public CartGetDTO getCart(int idCart) throws Exception
    {

        return null;
    }
}
