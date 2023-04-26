package co.edu.uniquindio.unimarket.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserGetDTO
{
    private int idUser;

    private  int idCard;

    private String name;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    List<ProductGetDTO> lstFav;
}