package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.DetailCartDTO;
import co.edu.uniquindio.unimarket.dto.DetailCartGetDTO;
import co.edu.uniquindio.unimarket.model.DetailCart;

import java.util.List;

public interface DetailCartService
{
    int createDetailCart(int id, DetailCartDTO detailCartDTO) throws Exception;
    List<DetailCartGetDTO> getDetailsForCart(int id) throws Exception;

    List<DetailCartGetDTO> convertLista(List<DetailCart> lstDetailCart);
}
