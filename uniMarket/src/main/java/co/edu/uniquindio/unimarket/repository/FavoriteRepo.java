package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.DetailCart;
import co.edu.uniquindio.unimarket.model.Favorite;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

public interface FavoriteRepo extends JpaAttributeConverter<Favorite, Integer> {
}
