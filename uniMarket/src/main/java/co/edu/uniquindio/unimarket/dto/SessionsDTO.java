package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class SessionsDTO
{
    private String email;

    private String password;

    private int type;
}
