package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.CommentsDTO;
import co.edu.uniquindio.unimarket.dto.CommentsGetDTO;

import java.util.List;

public interface CommentsService
{
    int createComment(CommentsDTO commentDTO);

    List<CommentsGetDTO> listComments(int productCode);
}
