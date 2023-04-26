package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.CartGetDTO;
import co.edu.uniquindio.unimarket.dto.DetailCartDTO;
import co.edu.uniquindio.unimarket.services.interfaces.CartService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

@SpringBootTest
@Transactional
public class CartServiceTest
{
    @Autowired
    private CartService cartService;

    @Test
    @Sql("classpath:dataset.sql")
    public void createCart()
    {

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getCart()
    {
        try {
            CartGetDTO cartGetDTO = cartService.getCart(1);

            Assertions.assertNotNull(cartGetDTO);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listCartForUser()
    {
        try {
            List<CartGetDTO> lstCart = cartService.listCartForUser(1094978017);

            Assertions.assertTrue(lstCart.size() > 0);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}