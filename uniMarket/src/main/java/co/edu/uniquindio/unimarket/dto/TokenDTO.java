package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TokenDTO
{
    @NotNull(message = "El token no puede ser nulo")
    @NotBlank(message = "El token no puede estar vacío")
    private String token;
    private String refreshToken;
}