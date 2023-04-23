package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>
{
    @Query("SELECT c FROM Cart c WHERE c.user.idCard = : idUser")
    List<Cart> findByCartIdUser(int idUser);
}