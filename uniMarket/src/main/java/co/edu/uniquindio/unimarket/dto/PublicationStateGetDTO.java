package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.Moderator;
import co.edu.uniquindio.unimarket.model.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PublicationStateGetDTO
{
    private int id;

    private List<State> stateList;

    private String reason;

    private LocalDateTime date;

    private Moderator moderator;

    private int idProduct;
}