package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.PaymentsMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PurchaseDTO
{
    private int userCode;
    private PaymentsMethod paymentsMethod;
    private List<PurchaseDetailDTO> purchaseDetailDTO;
}
