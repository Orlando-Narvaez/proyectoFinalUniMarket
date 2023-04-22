package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductDTO;
import co.edu.uniquindio.unimarket.dto.ProductGetDTO;
import co.edu.uniquindio.unimarket.model.Categories;
import co.edu.uniquindio.unimarket.model.State;

import java.util.List;
public interface ProductService
{
    int createProduct(ProductDTO productDTO) throws Exception;

    int updateProduct(int productCode, ProductDTO productDTO) throws Exception;

    int updateUnits(int productCode, int units) throws Exception;

    int updateState(int productCode, State state) throws Exception;

    int deleteProduct(int productCode) throws Exception;

    ProductGetDTO getProduct(int productCode) throws Exception;

    List<ProductGetDTO> listUserProducts(int productCode) throws Exception;

    List<ProductGetDTO> listCategoriesProducts(Categories categories) throws Exception;

    List<ProductGetDTO> listProductsByState(State state) throws Exception;

    List<ProductGetDTO> listFavoriteProducts(int userCode) throws Exception;

    List<ProductGetDTO> listProductsName(String name) throws Exception;

    List<ProductGetDTO> listProductPrice(float minimalPrice, float maximumPrice) throws Exception;
}