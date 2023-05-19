package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.GuaranteeDTO;
import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.dto.PQRDTO;
import co.edu.uniquindio.unimarket.services.interfaces.GuaranteeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/garantia")
@AllArgsConstructor
public class GuaranteeController
{
    private final GuaranteeService guaranteeService;

    @PostMapping
    public ResponseEntity<MessageDTO> crearGarantia(@Valid @RequestBody GuaranteeDTO guaranteeDTO) throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED,
                false,
                guaranteeService.createGuarantee(guaranteeDTO)
        ));
    }

    
}