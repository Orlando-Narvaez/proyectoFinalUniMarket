package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductDTO;
import co.edu.uniquindio.unimarket.dto.ProductGetDTO;
import co.edu.uniquindio.unimarket.model.Categories;
import co.edu.uniquindio.unimarket.model.Product;
import co.edu.uniquindio.unimarket.model.State;

import java.util.List;
public interface ProductService
{
    int createProduct(ProductDTO productDTO) throws Exception;

    int delateProduct(int idProduct) throws Exception;

    int updateProduct(int idProduct, ProductDTO productDTO) throws Exception;

    int updateForState(int idProduct, State state) throws Exception;

    ProductGetDTO getProduct(int idProduct) throws Exception;

    Product getProductBD(int idProduct) throws Exception;

    List<ProductGetDTO> listProductForCategorie(Categories categories) throws Exception;

    List<ProductGetDTO> listProductUser(int idCard) throws Exception;

    List<ProductGetDTO> listProductFavUser(int idCard) throws Exception;

    List<ProductGetDTO> listProductPrices(double priceMin, double priceMax) throws Exception;

    List<ProductGetDTO> listProductForNome(String name);
    List<ProductGetDTO> convertLstProduct(List<Product> products);
    List<ProductGetDTO> productosModeador();
}