package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.PQRDTO;
import co.edu.uniquindio.unimarket.dto.PQRGetDTO;

import java.util.List;

public interface PQRService
{
    int createPQR(PQRDTO pqrDTO) throws Exception;

    List<PQRDTO> listPQR(int id) throws Exception;

    PQRGetDTO getPQR(int id) throws Exception;
}