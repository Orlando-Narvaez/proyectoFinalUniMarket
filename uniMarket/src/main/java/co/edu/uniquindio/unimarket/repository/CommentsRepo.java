package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentsRepo extends JpaRepository<Comments,Integer>
{
    @Query("select c from Comments c where c.product.idProduct = :idProduct")
    List<Comments> getCommentsByIdProduct(int idProduct);
}