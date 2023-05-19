package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.FavoriteDTO;
import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.services.interfaces.FavoriteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/productos-favoritos")
@AllArgsConstructor
public class FavoriteController
{
    private final FavoriteService favoriteService;

    @PostMapping
    public ResponseEntity<MessageDTO> crearFavoritosUsuario(@Valid @RequestBody FavoriteDTO favoriteDTO) throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED,
                false,
                favoriteService.createFavorite(favoriteDTO)
        ));
    }

    @DeleteMapping("/{idFavorite}")
    public ResponseEntity<MessageDTO> eliminarFavoritosUsuario(@PathVariable int idFavorite, @Valid @RequestBody FavoriteDTO favoriteDTO) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                favoriteService.delateFavorite(favoriteDTO)
        ));
    }
}