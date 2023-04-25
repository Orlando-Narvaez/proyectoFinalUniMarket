package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Comments;
import co.edu.uniquindio.unimarket.model.PQR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PQRRepo extends JpaRepository<PQR, Integer>
{
    @Query("select p from PQR p where p.user.idCard = :idCard")
    List<Comments> getPqrIdUser(int idCard);
}
