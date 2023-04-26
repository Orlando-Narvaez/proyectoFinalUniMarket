package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.PQRDTO;
import co.edu.uniquindio.unimarket.dto.PQRGetDTO;
import co.edu.uniquindio.unimarket.services.interfaces.PQRService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class PQRServiceTest
{
    @Autowired
    private PQRService pqrService;

    @Test
    @Sql("classpath:dataset.sql")
    public void createPQR()
    {
        try {
            int idPQR = pqrService.createPQR(new PQRDTO(
                    "Aqui hay una sugerencia de test",
                    1
            ));

            Assertions.assertNotEquals(0, idPQR);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getPQR()
    {
        try {
            List<PQRGetDTO> lstPQR = (List<PQRGetDTO>) pqrService.getPQR(3);

            Assertions.assertNotEquals(0, lstPQR.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}