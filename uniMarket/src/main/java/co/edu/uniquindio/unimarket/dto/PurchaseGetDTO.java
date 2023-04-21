package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PurchaseGetDTO
{
    private int code;

    private LocalDateTime date;

    private float totalValue;

    private int userCode;

    //private PaymentsMethod paymentsMethod;

    private List<PurchaseDetailDTO> purchaseDetailDTO;
}
