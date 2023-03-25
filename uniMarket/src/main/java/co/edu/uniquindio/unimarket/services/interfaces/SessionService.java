package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.SessionsDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;
public interface SessionService
{
    TokenDTO login(SessionsDTO sessionDTO);

    void logout(int UserCode);
}
