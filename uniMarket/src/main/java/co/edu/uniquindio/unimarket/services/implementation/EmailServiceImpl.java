package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.services.interfaces.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService
{
    private final JavaMailSender javaMailSender;
    @Override
    public void sendEmail(EmailDTO emailDTO) throws Exception
    {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setSubject(emailDTO.getMailSubject());
        helper.setText(emailDTO.getBody(), true);
        helper.setTo(emailDTO.getAddressee());
        helper.setFrom("no_reply@dominio.com");
        javaMailSender.send(message);
    }
}