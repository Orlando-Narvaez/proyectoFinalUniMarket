package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Categories;
import co.edu.uniquindio.unimarket.model.Product;
import co.edu.uniquindio.unimarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer>
{
    @Query("select p from Product p where p.value >= :priceMin AND p.value <= :priceMax")
    List<Product> getProductRangePrice(double priceMin, double priceMax);

    @Query("select p from Product p where :categories member of p.categoriesList")
    List<Product> getProductCategories(Categories categories);

    @Query("select p from Product p where :user member of p.favorite")
    List<Product> getProductsFavs(User user);

    @Query("select p from Product p where p.name like concat('%', :name, '%') AND p.state = 'ACEPTADO' ")
    List<Product> getProductName(String name);

    @Query("select p from Product p where p.seller.idCard = :idCard and p.state = 0")
    List<Product> getProductUsers(int idCard);

    @Query("SELECT p FROM Product p")
    List<Product> productosModerador();
}