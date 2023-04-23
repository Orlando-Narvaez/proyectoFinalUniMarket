package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.model.Moderator;
import co.edu.uniquindio.unimarket.model.State;

public interface ModeratorService
{
    Moderator getModeratorId(int idMod) throws Exception;

    int updateState(int productCode, State state) throws Exception;
}