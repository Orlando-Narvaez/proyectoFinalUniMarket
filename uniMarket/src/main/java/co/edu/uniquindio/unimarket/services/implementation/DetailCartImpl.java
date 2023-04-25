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

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DetailCartImpl implements DetailCartService
{
    private final ProductService productService;
    private final CartService cartService;
    private final DetailCartRepo detailCartRepo;

    @Override
    public int createDetailCart(int id, DetailCartDTO detailCartDTO) throws Exception
    {
        DetailCart detailCart = new DetailCart();

        detailCart.setCart(cartService.getCartBD(id));
        detailCart.setAmount(detailCartDTO.getAmount());
        detailCart.setValue(detailCartDTO.getValue());
        detailCart.setProduct(productService.getProductBD(detailCart.getId()));

        return detailCartRepo.save(detailCart).getId();
    }

    @Override
    public List<DetailCartGetDTO> getDetailsForCart(int id) throws Exception
    {
        List<DetailCartGetDTO> lstAnswerDetail = new ArrayList<>();
        List<DetailCart> lstDetailCar = detailCartRepo.getDetailCartForCart(id);
        if (lstDetailCar != null && lstDetailCar.size() > 0) {
            lstDetailCar.forEach(detailCart -> {
                lstAnswerDetail.add(convertDetailCart(detailCart));
            });
        }

        return lstAnswerDetail;
    }

    @Override
    public List<DetailCartGetDTO> convertLista(List<DetailCart> lstDetailCart)
    {
        List<DetailCartGetDTO> lstDetailAnswer = new ArrayList<>();
        if (lstDetailCart != null && lstDetailCart.size() > 0) {
            lstDetailCart.forEach(detailCart -> {
                lstDetailAnswer.add(convertDetailCart(detailCart));
            });
        }

        return lstDetailAnswer;
    }

    private DetailCartGetDTO convertDetailCart(DetailCart detailCart) {
        DetailCartGetDTO detailCartGetDTO = new DetailCartGetDTO(
                detailCart.getId(),
                detailCart.getValue(),
                detailCart.getAmount(),
                detailCart.getProduct().getIdProduct()
        );

        return detailCartGetDTO;
    }
}
