package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ProductDTO;
import co.edu.uniquindio.unimarket.dto.ProductGetDTO;
import co.edu.uniquindio.unimarket.model.Categories;
import co.edu.uniquindio.unimarket.model.Product;
import co.edu.uniquindio.unimarket.model.State;
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

    @Test
    @Sql("classpath:dataset.sql")
    public void delateProduct()
    {
        try {
            int idProduct = productService.delateProduct(2);

            Assertions.assertEquals(3, idProduct);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void updateProduct()
    {
        try {
            Product product = productService.getProductBD(3);
            product.setValue(10000);

            ProductDTO productDTO = new ProductDTO(
                    product.getName(),
                    product.getValue(),
                    product.getDescription(),
                    product.getSeller().getIdUser(),
                    product.getImages(),
                    product.getCategoriesList()
            );

            int id = productService.updateProduct(3, productDTO);

            Assertions.assertEquals(3, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void updateForState()
    {
        try {
            int id = productService.updateForState(3, State.DENEGADO);

            Assertions.assertEquals(3, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getProduct()
    {
        try {
            ProductGetDTO productGetDTO = productService.getProduct(1);

            Assertions.assertNotNull(productGetDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listProductForCategorie()
    {
        try {
            List<ProductGetDTO> lstProducts = productService.listProductForCategorie(Categories.Juegos);

            Assertions.assertNotEquals(0, lstProducts.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listProductUser()
    {
        try {
            List<ProductGetDTO> lstProducts = productService.listProductUser(1094978017);

            Assertions.assertNotEquals(0, lstProducts.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listProductFavUser()
    {
        try {
            List<ProductGetDTO> lstProducts = productService.listProductFavUser(1094978017);

            Assertions.assertNotEquals(0, lstProducts.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listProductPrices()
    {
        try {
            List<ProductGetDTO> lstProducts = productService.listProductPrices(100000,200000);

            Assertions.assertNotEquals(0, lstProducts.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listProductForNome() {
        try {
            List<ProductGetDTO> lstProducts = productService.listProductForNome("Nevera");

            Assertions.assertNotEquals(0, lstProducts.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}