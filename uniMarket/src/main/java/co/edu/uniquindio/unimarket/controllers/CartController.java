package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.CartDTO;
import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.model.StateCart;
import co.edu.uniquindio.unimarket.services.interfaces.CartService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cart")
@AllArgsConstructor
public class CartController
{
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<MessageDTO> crearCarrito(@Valid @RequestBody CartDTO cartDTO) throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED,
                false,
                cartService.createCart(cartDTO)
        ));
    }

    @GetMapping("/{idCart}")
    public ResponseEntity<MessageDTO> obtenerCarrito(@PathVariable int idCart) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                cartService.getCart(idCart)
        ));
    }

    @GetMapping("/{idCard}")
    public ResponseEntity<MessageDTO> obtenerCarritoUsuario(@PathVariable int idCard) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                cartService.listCartForUser(idCard)
        ));
    }

    @GetMapping("/{stateCart}")
    public ResponseEntity<MessageDTO> obtenerCarritoEstado(@PathVariable StateCart stateCart) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                cartService.listCartForState(stateCart)
        ));
    }
}