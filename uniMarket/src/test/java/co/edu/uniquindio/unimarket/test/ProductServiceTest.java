package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ProductDTO;
import co.edu.uniquindio.unimarket.model.Categories;
import co.edu.uniquindio.unimarket.services.interfaces.ProductService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest
@Transactional
public class ProductServiceTest
{
    @Autowired
    private ProductService productService;

    @Test
    @Sql("classpath:dataset.sql")
    public void createProduct()
    {
        try {
            Map<String,String> lstImages = new LinkedCaseInsensitiveMap<>();
            lstImages.put("1", "https://www.wallpaperbetter.com/es/hd-wallpaper-asswj");
            List<Categories> lstCategories = new ArrayList<>();
            lstCategories.add(Categories.Belleza);
            ProductDTO productDTO = new ProductDTO(
                    "Producto de prueba",
                    15000,
                    "Pertenece el producto a un test",
                    1,
                    lstImages,
                    lstCategories
            );

            int idProduct = productService.createProduct(productDTO);

            Assertions.assertNotEquals(0, idProduct);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
