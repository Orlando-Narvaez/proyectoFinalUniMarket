package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.DetailCart;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

public interface DetailCartRepo extends JpaAttributeConverter<DetailCart, Integer>
{

}
