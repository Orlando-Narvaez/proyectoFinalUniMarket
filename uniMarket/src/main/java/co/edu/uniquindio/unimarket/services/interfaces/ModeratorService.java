package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.model.Moderator;
import co.edu.uniquindio.unimarket.model.State;

public interface ModeratorService
{
    boolean updateState(int productCode, State state) throws Exception;
}