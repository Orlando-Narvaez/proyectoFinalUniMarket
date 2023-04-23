package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.ProductDTO;
import co.edu.uniquindio.unimarket.dto.ProductGetDTO;
import co.edu.uniquindio.unimarket.model.Categories;
import co.edu.uniquindio.unimarket.model.Product;
import co.edu.uniquindio.unimarket.repository.ProductRepo;
import co.edu.uniquindio.unimarket.services.interfaces.ProductService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private  final ProductRepo productRepo;
    @Override
    public int createProduct(ProductDTO productDTO) throws Exception {
        Product product = new Product();
        return productRepo.save(product).getIdProduct();
    }

    @Override
    public int updateProduct(int idProduct, ProductDTO productDTO) throws Exception {
        return 0;
    }

    @Override
    public int updateUnits(int idProduct, int amount) throws Exception {
        return 0;
    }

    @Override
    public int updateState(int idProduct, boolean state) throws Exception {
        return 0;
    }

    @Override
    public int deleteProduct(int idProduct) throws Exception {
        Product product = new Product();
        return  0; //productRepo.deleteById(idProduct);
    }

    @Override
    public ProductGetDTO getProduct(int idProduct) throws Exception {

        Optional<Product> product = productRepo.findById(idProduct);
        return null;
    }

    @Override
    public List<ProductGetDTO> listUserProducts(int idProduct) throws Exception {
        return null;
    }

    @Override
    public List<ProductGetDTO> listCategoriesProducts(Categories categories) throws Exception {
        return null;
    }

    @Override
    public List<ProductGetDTO> listProductsByState(boolean state) throws Exception {
        return null;
    }

    @Override
    public List<ProductGetDTO> listFavoriteProducts(int idUser) throws Exception {
        return null;
    }

    @Override
    public List<ProductGetDTO> listProductsName(String name) throws Exception {
        return null;
    }

    @Override
    public List<ProductGetDTO> listProductPrice(float minimalPrice, float maximumPrice) throws Exception {
        List<Product> lstPRoducts = productRepo.getProductsWithRange(minimalPrice, maximumPrice);
    }

    @Override
    public Product search(int idProduct) throws Exception {
        return null;
    }
}