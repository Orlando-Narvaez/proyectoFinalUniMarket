package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer>
{
    //@Query("select p from Producto p where p.vendedor.codigo = :codigoUsuario")
    //List<Producto> listarProductosUsuario(int codigoUsuario);
    @Query("select p from Product p where p.user.idUser = :idUser")
    Product getFavoritesByUser(int idUser);
    @Query("select p from Product p where p.value >= :startPrice and p.value <= :endPrice")
    List<Product> getProductsWithRange(float startPrice, float endPrice);

    @Query("select p from Product p where p.name like concat( '%', :name, '%' ) and p.state = true ")
    List<Product> listProductForName(String name);
}
