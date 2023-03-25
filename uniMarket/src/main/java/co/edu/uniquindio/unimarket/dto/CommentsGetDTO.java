package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class CommentsGetDTO
{
    private int code;

    private LocalDateTime date;

    private String message;

    private int userCode;

    private int productoCode;
}
