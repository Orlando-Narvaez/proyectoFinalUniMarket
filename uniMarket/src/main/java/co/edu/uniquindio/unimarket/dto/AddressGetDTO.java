package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AddressGetDTO
{
    private int id;
    private String descripcion;
    private int postalCod;
    private String idCardUser;
}