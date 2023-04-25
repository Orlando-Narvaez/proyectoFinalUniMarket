package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>
{
    @Query("select c from Cart c where c.user.idCard = :idCard")
    List<Cart> getLstCartForUser(int idCard);
}