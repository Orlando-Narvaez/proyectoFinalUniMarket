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

    int updateProduct(int idProduct, ProductDTO productDTO) throws Exception;

    int updateUnits(int idProduct, int amount) throws Exception;

    int updateState(int idProduct, boolean state) throws Exception;

    int deleteProduct(int idProduct) throws Exception;

    ProductGetDTO getProduct(int idProduct) throws Exception;

    List<ProductGetDTO> listUserProducts(int idProduct) throws Exception;

    List<ProductGetDTO> listCategoriesProducts(Categories categories) throws Exception;

    List<ProductGetDTO> listProductsByState(boolean state) throws Exception;

    List<ProductGetDTO> listFavoriteProducts(int idUser) throws Exception;

    List<ProductGetDTO> listProductsName(String name) throws Exception;

    List<ProductGetDTO> listProductPrice(float minimalPrice, float maximumPrice) throws Exception;

    Product search(int idProduct) throws Exception;
}