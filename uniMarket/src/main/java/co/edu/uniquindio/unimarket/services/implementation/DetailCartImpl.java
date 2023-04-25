package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.DetailCartDTO;
import co.edu.uniquindio.unimarket.dto.DetailCartGetDTO;
import co.edu.uniquindio.unimarket.model.DetailCart;
import co.edu.uniquindio.unimarket.repository.DetailCartRepo;
import co.edu.uniquindio.unimarket.services.interfaces.CartService;
import co.edu.uniquindio.unimarket.services.interfaces.DetailCartService;
import co.edu.uniquindio.unimarket.services.interfaces.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailCartImpl implements DetailCartService
{
    private final ProductService productService;
    private final CartService cartService;
    private final DetailCartRepo detailCartRepo;

    @Override
    public int createDetailCart(int id, DetailCartDTO detailCartDTO) throws Exception {
        return 0;
    }

    @Override
    public List<DetailCartGetDTO> getDetailsForCart(int id) throws Exception {
        return null;
    }

    @Override
    public List<DetailCartGetDTO> convertLista(List<DetailCart> lstDetailCart) {
        return null;
    }
}
