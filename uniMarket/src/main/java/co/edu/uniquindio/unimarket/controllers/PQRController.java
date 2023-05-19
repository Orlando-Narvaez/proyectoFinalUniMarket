package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.dto.PQRDTO;
import co.edu.uniquindio.unimarket.services.interfaces.PQRService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pqr")
@AllArgsConstructor
public class PQRController
{
    private final PQRService pqrService;

    @PostMapping
    public ResponseEntity<MessageDTO> crearPQR(@Valid @RequestBody PQRDTO pqrdto) throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED,
                false,
                pqrService.createPQR(pqrdto)
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> actualizarPQR(@PathVariable int id, @Valid @RequestBody PQRDTO pqrdto) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                pqrService.updatePQR(id, pqrdto)
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> obtenerPQR(@PathVariable int id) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                pqrService.getPQR(id)
        ));
    }
}