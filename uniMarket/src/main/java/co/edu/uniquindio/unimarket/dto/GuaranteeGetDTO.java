package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class GuaranteeGetDTO
{
    private int idGuarantee;

    private String describeGuarantee;

    private LocalDateTime dataRequest;

    private int idProduct;

    private int idUser;
}