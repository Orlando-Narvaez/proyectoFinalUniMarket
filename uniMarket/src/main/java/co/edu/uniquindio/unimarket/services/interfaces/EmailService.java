package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
public interface EmailService
{
    String sendEmail(EmailDTO emailDTO);
}
