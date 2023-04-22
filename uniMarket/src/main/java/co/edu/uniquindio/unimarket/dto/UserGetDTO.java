package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserGetDTO
{
    private int code;

    private String name;

    private String email;

    private String address;

    private String phoneNumber;
}