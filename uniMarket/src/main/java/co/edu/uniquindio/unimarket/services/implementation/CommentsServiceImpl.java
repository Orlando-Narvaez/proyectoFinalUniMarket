package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.CommentsDTO;
import co.edu.uniquindio.unimarket.dto.CommentsGetDTO;
import co.edu.uniquindio.unimarket.model.Comments;
import co.edu.uniquindio.unimarket.repository.CommentsRepo;
import co.edu.uniquindio.unimarket.services.interfaces.CommentsService;
import co.edu.uniquindio.unimarket.services.interfaces.ProductService;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentsServiceImpl implements CommentsService
{
    private final CommentsRepo commentsRepo;
    private final UserService userService;
    private  final ProductService productService;

    @Override
    public int createComment(CommentsDTO commentDTO) throws Exception
    {
        Comments comments = new Comments();

        comments.setComment(commentDTO.getMessage());
        comments.setDateComment(LocalDateTime.now());
        comments.setUser(userService.getUserDataBase(commentDTO.getUserCode()));
        comments.setProduct(productService.getProductBD(commentDTO.getProductCode()));
        return commentsRepo.save(comments).getId();
    }

    @Override
    public List<CommentsGetDTO> listComments(int productCode) throws Exception
    {
        List<Comments> lstComments = commentsRepo.getCommentsByIdProduct(productCode);
        List<CommentsGetDTO> lstCommentsGetDTO = new ArrayList<>();

        if (lstComments != null && lstComments.size() > 0)
        {
            lstComments.forEach(comments -> {
                lstCommentsGetDTO.add(convertComments(comments));
            });
        }
        return lstCommentsGetDTO;
    }

    @Override
    public CommentsGetDTO getComment(int commentCode) throws Exception
    {
        return convertComments(comments(commentCode));
    }

    private CommentsGetDTO convertComments(Comments comments) {
        CommentsGetDTO commentsGetDTO = new CommentsGetDTO(
                comments.getId(),
                comments.getDateComment(),
                comments.getComment(),
                comments.getProduct().getIdProduct(),
                comments.getUser().getIdCard());
        return commentsGetDTO;
    }

    private Comments comments(int idComment) throws Exception
    {
        Optional<Comments> comments = commentsRepo.findById(idComment);
        if (comments.isEmpty()) {
            throw new Exception("Comentario fallido no existe");
        }
        return comments.get();
    }
}