package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.model.State;
import co.edu.uniquindio.unimarket.services.interfaces.ModeratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/moderador")
@RestController
@AllArgsConstructor
public class ModeratorController
{
    private final ModeratorService moderatorService;
    @GetMapping("/aprobar-rechazar-producto/{idProduct}/{state}")
    public ResponseEntity<MessageDTO> aprobarRechazarProducto(int idProduct, State state) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                moderatorService.updateState(idProduct, state)
        ));
    }
}