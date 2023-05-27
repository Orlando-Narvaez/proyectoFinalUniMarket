package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.SessionsDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;

public interface SessionService
{
    TokenDTO login(SessionsDTO sessionDTO) throws Exception;

    void logout(int UserCode) throws Exception;

    TokenDTO refreshToken(TokenDTO tokenDTO) throws Exception;
}