package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.PurchaseDTO;
import co.edu.uniquindio.unimarket.dto.PurchaseGetDTO;

import java.util.List;
public interface PurchaseService
{
    int createPurchase(PurchaseDTO purchaseDTO);

    List<PurchaseGetDTO> listPurchases(int userCode);

    PurchaseGetDTO getPurchase(int purchaseCode);
}
