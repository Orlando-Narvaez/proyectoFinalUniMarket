package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class EmailDTO
{
    private String affair;
    private String body;
    private String addressee;
}
