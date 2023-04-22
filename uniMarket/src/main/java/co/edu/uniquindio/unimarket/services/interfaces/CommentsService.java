package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.CommentsDTO;
import co.edu.uniquindio.unimarket.dto.CommentsGetDTO;
import java.util.List;

public interface CommentsService
{
    int createComment(CommentsDTO commentDTO) throws Exception;

    List<CommentsGetDTO> listComments(int productCode) throws Exception;
}