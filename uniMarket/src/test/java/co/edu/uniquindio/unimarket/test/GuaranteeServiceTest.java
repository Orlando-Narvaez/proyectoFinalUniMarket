package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.GuaranteeDTO;
import co.edu.uniquindio.unimarket.dto.GuaranteeGetDTO;
import co.edu.uniquindio.unimarket.services.interfaces.GuaranteeService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;
import java.util.Map;

@SpringBootTest
@Transactional
public class GuaranteeServiceTest
{
    @Autowired
    private GuaranteeService guaranteeService;

    @Test
    @Sql("classpath:dataset.sql")
    public void createGuarantee()
    {
        try {
            Map<String,String> lstImages = new LinkedCaseInsensitiveMap<>();
            lstImages.put("1", "https://www.wallpaperbetter.com/es/hd-wallpaper-asswj");
            int idGuarantee = guaranteeService.createGuarantee(new GuaranteeDTO(
                    "La pavona",
                    lstImages,
                    1,
                    1094978017
            ));

            Assertions.assertNotEquals(0, idGuarantee);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listGuarantee()
    {
        try {
            List<GuaranteeGetDTO> lstGuarantee = guaranteeService.listGuarantee(3);

            Assertions.assertEquals(1, lstGuarantee.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}