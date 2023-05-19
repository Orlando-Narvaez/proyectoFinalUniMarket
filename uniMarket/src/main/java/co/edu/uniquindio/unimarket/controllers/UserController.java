package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.dto.UserDTO;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@AllArgsConstructor

public class UserController
{
    @Autowired
    private final UserService userService;


    @PostMapping
    public ResponseEntity<MessageDTO> registrarUsuario(@Valid @RequestBody UserDTO userDTO) throws Exception
    {
        int idCard = userService.createUser(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED, false,
                "Cliente " + idCard + " creado exitosamente"));
    }
    @PutMapping("/{idCard}")
    public ResponseEntity<MessageDTO> actualizarUsuario(@PathVariable int idCard, @Valid @RequestBody UserDTO userDTO) throws Exception {

        int idCardUpdate = userService.updateUser(idCard, userDTO);

        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK, false,
                "Cliente " + idCardUpdate + " actualizado exitosamente"));
    }
    @GetMapping("/{idCard}")
    public ResponseEntity<MessageDTO> obtenerUsuario(int idCard) throws Exception
    {
        return  ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK, false,
                userService.getUser(idCard)
        ));
    }
    @GetMapping
    public ResponseEntity<MessageDTO> obtenerUsuarios() throws Exception {
        return  ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK, false,
                userService.getUsers()
        ));
    }
}