package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.CommentsDTO;
import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.services.interfaces.CommentsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
@AllArgsConstructor
public class CommentsController
{
    private final CommentsService commentsService;

    @PostMapping
    public ResponseEntity<MessageDTO> crearComentario(@Valid @RequestBody CommentsDTO comentarioDTO) throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED,
                false,
                commentsService.createComment(comentarioDTO)
        ));
    }
    @GetMapping("/{idProduct}")
    public ResponseEntity<MessageDTO> listComments(@PathVariable int idProduct) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                commentsService.listComments(idProduct)
        ));
    }
}