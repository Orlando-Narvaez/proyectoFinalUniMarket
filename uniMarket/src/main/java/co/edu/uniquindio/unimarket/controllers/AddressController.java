package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.AddressDTO;
import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.services.interfaces.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/address")
@AllArgsConstructor
public class AddressController
{
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<MessageDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO) throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED,
                false,
                addressService.createAddress(addressDTO)
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> upsdateAddress(@PathVariable int id, @Valid @RequestBody AddressDTO addressDTO) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                addressService.upsdateAddress(id, addressDTO)
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> delateAddress(@PathVariable int id) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                addressService.delateAddress(id)
        ));
    }
}