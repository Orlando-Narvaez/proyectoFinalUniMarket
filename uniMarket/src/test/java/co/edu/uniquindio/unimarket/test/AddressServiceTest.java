package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.AddressDTO;
import co.edu.uniquindio.unimarket.dto.AddressGetDTO;
import co.edu.uniquindio.unimarket.model.Address;
import co.edu.uniquindio.unimarket.services.interfaces.AddressService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

@SpringBootTest
@Transactional
public class AddressServiceTest
{
    @Autowired
    private AddressService addressService;

    @Test
    @Sql("classpath:dataset.sql")
    public void createAddress()
    {
        try {
            int idAddress = addressService.createAddress(new AddressDTO(
                    "La pavona",
                    60003,
                    1094978017
            ));

            Assertions.assertNotEquals(0, idAddress);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void upsdateAddress()
    {
        try {
            Address address = addressService.getAddresBD(1094978017);
            address.setDescription("Villa Liliana");
            int id = addressService.upsdateAddress(1094978017, new AddressDTO(
                    address.getDescription(),
                    address.getPostalCod(),
                    address.getUser().getIdCard()
            ));

            Assertions.assertEquals(0, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delateAddress()
    {
        try {
            boolean answer = addressService.delateAddress(1094978017);

            Assertions.assertNotEquals(true, answer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void getAddressUser()
    {
        try {
            List<AddressGetDTO> lstAddress = addressService.getAddressUser("1094978017");

            Assertions.assertNotEquals(0, lstAddress.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}