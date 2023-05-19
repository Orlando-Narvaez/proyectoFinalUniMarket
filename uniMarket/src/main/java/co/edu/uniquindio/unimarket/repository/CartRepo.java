package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Cart;
import co.edu.uniquindio.unimarket.model.StateCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>
{
    @Query("select c from Cart c where c.user.idCard = :idCard")
    List<Cart> getLstCartForUser(int idCard);

    @Query("select c from Cart c where c.stateCart = :stateCart")
    List<Cart> getLstCartForState(StateCart stateCart);
}