package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.PQRDTO;
import co.edu.uniquindio.unimarket.dto.PQRGetDTO;
import co.edu.uniquindio.unimarket.model.PQR;
import co.edu.uniquindio.unimarket.repository.PQRRepo;
import co.edu.uniquindio.unimarket.services.interfaces.PQRService;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PQRServiceImpl implements PQRService
{
    private final PQRRepo pqrRepo;
    private final UserService userService;

    @Override
    public int createPQR(PQRDTO pqrDTO) throws Exception
    {
        PQR newPqr = new PQR();

        newPqr.setDescription(pqrDTO.getDescription());
        newPqr.setUser(userService.getUserDataBase(pqrDTO.getIdCartUser()));
        newPqr.setDateRequest(LocalDateTime.now());

        return pqrRepo.save(newPqr).getId();
    }

    @Override
    public int updatePQR(int id, PQRDTO pqrdto) throws Exception
    {
        List<PQR> lstPQR = new ArrayList<>();
        PQR pqr = getPQRBD(id);

        pqr.setDescription(pqrdto.getDescription());
        return pqrRepo.save(pqr).getId();
    }

    @Override
    public PQRGetDTO getPQR(int id) throws Exception {
        return convertPQR(getPQRBD(id));
    }

    private PQR getPQRBD(int id) throws Exception {
        PQR pqr = pqrRepo.getById(id);

        if (pqr != null) {
            throw new Exception("No existe la PQR con la id "+id);
        }

        return pqr;
    }


    private PQRGetDTO convertPQR(PQR pqr) {
        PQRGetDTO pqrGetDTO = new PQRGetDTO(
                pqr.getId(),
                pqr.getDescription(),
                pqr.getState(),
                pqr.getDateRequest(),
                pqr.getUser().getIdCard(),
                pqr.getModerator().getIdCard());
        return pqrGetDTO;
    }
}
