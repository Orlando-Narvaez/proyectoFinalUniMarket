package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductDTO;
import co.edu.uniquindio.unimarket.dto.ProductGetDTO;
import co.edu.uniquindio.unimarket.model.Categories;
import co.edu.uniquindio.unimarket.model.State;

import java.util.List;
public interface ProductService
{
    int createProduct(ProductDTO productDTO);

    int updateProduct(int productCode, ProductDTO productDTO);

    int updateUnits(int productCode, int units);

    int updateState(int productCode, State state);

    int deleteProduct(int productCode);

    ProductGetDTO getProduct(int productCode);

    List<ProductGetDTO> listUserProducts(int productCode);

    List<ProductGetDTO> listCategoriesProducts(Categories categories);

    List<ProductGetDTO> listProductsByState(State state);

    List<ProductGetDTO> listFavoriteProducts(int userCode);

    List<ProductGetDTO> listProductsName(String name);

    List<ProductGetDTO> listProductPrice(float minimalPrice, float maximumPrice);
}
