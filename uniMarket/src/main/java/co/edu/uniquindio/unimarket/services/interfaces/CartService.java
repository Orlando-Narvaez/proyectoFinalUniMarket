package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.PurchaseDTO;
import co.edu.uniquindio.unimarket.dto.PurchaseGetDTO;
import java.util.List;

public interface CartService
{
    int createPurchase(PurchaseDTO purchaseDTO) throws Exception;

    List<PurchaseGetDTO> listPurchases(int userCode) throws Exception;

    PurchaseGetDTO getPurchase(int purchaseCode) throws Exception;
}