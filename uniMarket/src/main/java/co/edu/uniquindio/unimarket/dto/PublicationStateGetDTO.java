package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.Moderator;
import co.edu.uniquindio.unimarket.model.State;

import java.time.LocalDateTime;
import java.util.List;

public class PublicationStateGetDTO
{
    private int id;

    private List<State> stateList;

    private String reason;

    private LocalDateTime date;

    private Moderator moderator;

    private int idProduct;
}
