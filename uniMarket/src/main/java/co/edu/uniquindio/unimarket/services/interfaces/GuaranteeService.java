package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.GuaranteeDTO;
import co.edu.uniquindio.unimarket.dto.GuaranteeGetDTO;
import java.util.List;

public interface GuaranteeService
{
    int createGuarantee(GuaranteeDTO guaranteeDTO) throws Exception;

    List<GuaranteeGetDTO> listGuarantee(int idGuarantee) throws Exception;
}