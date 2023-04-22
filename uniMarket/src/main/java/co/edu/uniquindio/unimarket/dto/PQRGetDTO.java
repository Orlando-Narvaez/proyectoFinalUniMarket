package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PQRGetDTO
{
    private int id;

    private String description;

    private Boolean state;

    private LocalDateTime dateRequest;

    private int idCartUser;

    private int idMod;
}