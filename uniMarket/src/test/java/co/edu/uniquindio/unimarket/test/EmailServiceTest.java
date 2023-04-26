package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.services.interfaces.EmailService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class EmailServiceTest
{
    @Autowired
    private EmailService emailService;

    @Test
    public void sendEmail()
    {
        try {
            emailService.sendEmail(new EmailDTO(
                    "Correo del test",
                    "Correo que se ejecuto del test",
                    "juliancho.quiroga@hotmail.com"
            ));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}