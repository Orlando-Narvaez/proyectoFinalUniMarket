package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.services.interfaces.CloudinaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/img")
@AllArgsConstructor
public class ImagesController
{
    private final CloudinaryService cloudinaryService;
    @PostMapping("/upload")
    public ResponseEntity<MessageDTO> subirImagen(@RequestParam("file") List<MultipartFile> lstFiles) throws Exception
    {
        List<Map> lstResponse = new ArrayList<>();
        for (MultipartFile file : lstFiles) {
            File image = cloudinaryService.convert(file);
            lstResponse.add(cloudinaryService.uploadImage(image, "proyecto"));
        }
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(
                HttpStatus.OK, false,
                lstResponse ) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> eliminarImagen(@PathVariable String id) throws Exception
    {
        Map respuesta = cloudinaryService.deleteImage(id);
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                respuesta ) );
    }
}