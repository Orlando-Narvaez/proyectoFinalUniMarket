package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.GuaranteeDTO;
import co.edu.uniquindio.unimarket.dto.GuaranteeGetDTO;
import co.edu.uniquindio.unimarket.model.Guarantee;
import co.edu.uniquindio.unimarket.repository.GuaranteeRepo;
import co.edu.uniquindio.unimarket.services.interfaces.GuaranteeService;
import co.edu.uniquindio.unimarket.services.interfaces.ProductService;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GuaranteeServiceImpl implements GuaranteeService
{
    private final GuaranteeRepo guaranteeRepo;
    private final UserService userService;
    private  final ProductService productService;

    @Override
    public int createGuarantee(GuaranteeDTO guaranteeDTO) throws Exception
    {
        Guarantee newGuarantee = new Guarantee();

        newGuarantee.setDescribeGuarantee(guaranteeDTO.getDescribeGuarantee());
        newGuarantee.setDataRequest(LocalDateTime.now());
        newGuarantee.setProduct(productService.getProductBD(guaranteeDTO.getIdProduct()));
        newGuarantee.setUser(userService.getUserDataBase(guaranteeDTO.getIdUser()));
        return 0;
    }

    @Override
    public List<GuaranteeGetDTO> listGuarantee(int idGuarantee) throws Exception
    {
        List<Guarantee> lstGuarantee = guaranteeRepo.getGuaranteeUser(idGuarantee);
        List<GuaranteeGetDTO> lstGuaranteeDTO = new ArrayList<>();

        if (lstGuarantee != null && lstGuarantee.size() > 0)
        {
            lstGuarantee.forEach(guarantee -> {
                lstGuaranteeDTO.add(convertGuarantee(guarantee));
            });
        }
        return lstGuaranteeDTO;
    }


    private GuaranteeGetDTO convertGuarantee(Guarantee guarantee) {
        GuaranteeGetDTO guaranteeGetDTO = new GuaranteeGetDTO(
                guarantee.getIdGuarantee(),
                guarantee.getDescribeGuarantee(),
                guarantee.getDataRequest(),
                guarantee.getProduct().getIdProduct(),
                guarantee.getUser().getIdCard()
        );
        return guaranteeGetDTO;
    }
}