package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.CartDTO;
import co.edu.uniquindio.unimarket.dto.CartGetDTO;
import co.edu.uniquindio.unimarket.dto.DetailCartGetDTO;
import co.edu.uniquindio.unimarket.model.Cart;
import co.edu.uniquindio.unimarket.model.Product;
import co.edu.uniquindio.unimarket.model.StateCart;
import co.edu.uniquindio.unimarket.model.User;
import co.edu.uniquindio.unimarket.repository.CartRepo;
import co.edu.uniquindio.unimarket.services.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService
{
    private final CartRepo cartRepo;
    private final DetailCartService detailCartService;
    private final UserService userService;
    private final ProductService productService;
    private final EmailService emailService;
    private final AddressService addressService;
    @Override
    public int createCart(CartDTO cartDTO) throws Exception
    {
        return 0;
    }

    @Override
    public CartGetDTO getCart(int idCart) throws Exception
    {
        return convertCart(getCartBD(idCart));
    }

    @Override
    public Cart getCartBD(int idCart) throws Exception
    {
        Optional<Cart> compra = cartRepo.findById(idCart);
        if (compra.isEmpty()) {
            throw new Exception("La compra asociada al código " + idCart + " no existe");
        }

        return compra.get();
    }

    @Override
    public List<CartGetDTO> listCartForUser(int idCard) throws Exception {
        List<CartGetDTO> lstCartAnswer= new ArrayList<>();
        List<Cart> lstCart = cartRepo.getLstCartForUser(idCard);
        if (lstCart != null && lstCart.size() > 0) {
            lstCart.forEach(compra -> {
                lstCartAnswer.add(convertCart(compra));
            });
        }

        return lstCartAnswer;
    }

    private CartGetDTO convertCart(Cart cart)
    {
        CartGetDTO cartGetDTO = new CartGetDTO(
                cart.getIdCart(),
                cart.getBuyDate(),
                cart.getUser().getIdUser(),
                cart.getTotalValue(),
                detailCartService.convertLista(cart.getDetailCartList()),
        );

        return cartGetDTO;
    }
}