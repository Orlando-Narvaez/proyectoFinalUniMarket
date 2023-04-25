package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.DetailCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetailCartRepo extends JpaRepository<DetailCart, Integer>
{
    @Query("select d from DetailCart d WHERE d.cart.idCart = :idCart")
    List<DetailCart> getDetailCartForCart(int idCart);
}
