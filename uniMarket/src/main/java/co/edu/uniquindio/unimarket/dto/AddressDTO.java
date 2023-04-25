package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Setter
@Getter
public class AddressDTO
{
    @NotNull
    @NotBlank
    @Length(max = 200, message = "El campo descripción debe tener como máximo 200 caracteres")
    private String descripcion;
    @NotNull
    private int postalCod;
    @NotNull
    private String idCardUser;
}