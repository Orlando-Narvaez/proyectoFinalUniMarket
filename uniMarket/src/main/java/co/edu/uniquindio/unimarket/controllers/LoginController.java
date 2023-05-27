package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.dto.SessionsDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;
import co.edu.uniquindio.unimarket.dto.UserDTO;
import co.edu.uniquindio.unimarket.services.interfaces.SessionService;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class LoginController
{
    private final UserService userService;
    private final SessionService sessionService;

    @PostMapping("/login")
    public ResponseEntity<MessageDTO> login(@Valid @RequestBody SessionsDTO loginUser) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(
                HttpStatus.OK, false,
                sessionService.login(loginUser)
        ));
    }

    @PostMapping("/registerUser")
    public ResponseEntity<MessageDTO> registerUser(@Valid @RequestBody UserDTO user) throws Exception {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED,
                false, "Usuario registrado satisfactoriamente"));
    }

    @PostMapping("/refresh")
    public ResponseEntity<MessageDTO> refreshToken(@Valid @RequestBody TokenDTO tokenDTO) throws  Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                sessionService.refreshToken(tokenDTO))) ;
    }
}