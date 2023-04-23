package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.DetailCartGetDTO;
import co.edu.uniquindio.unimarket.model.DetailCart;

public interface DetailCartService
{
    DetailCartGetDTO getCartDetail(int id) throws Exception;

    //DetailCart get(int id) throws Exception;
}
