package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.services.interfaces.CloudinaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("api/images")
@AllArgsConstructor
public class ImagesController
{
    private final CloudinaryService cloudinaryService;
    @PostMapping("/upload")
    public ResponseEntity<MessageDTO> subirImagen(@RequestParam("file") MultipartFile file) throws Exception
    {
        File imagen = cloudinaryService.convert(file);
        Map respuesta = cloudinaryService.uploadImage(imagen, "proyecto");
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(
                HttpStatus.OK, false,
                respuesta ) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> eliminarImagen(@PathVariable String id) throws Exception
    {
        Map respuesta = cloudinaryService.deleteImage(id);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                respuesta ) );
    }
}