package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.ImgDTO;
import co.edu.uniquindio.unimarket.dto.ProductDTO;
import co.edu.uniquindio.unimarket.dto.ProductGetDTO;
import co.edu.uniquindio.unimarket.model.Categories;
import co.edu.uniquindio.unimarket.model.Product;
import co.edu.uniquindio.unimarket.model.State;
import co.edu.uniquindio.unimarket.model.User;
import co.edu.uniquindio.unimarket.repository.ProductRepo;
import co.edu.uniquindio.unimarket.services.interfaces.ProductService;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductRepo productRepo;
    private final UserService userService;

    @Override
    public int createProduct(ProductDTO productDTO) throws Exception
    {
        Map<String, String> imagenes = productDTO.getImagenes().stream().collect(
                Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

        Product newProduct = new Product();

        newProduct.setName(productDTO.getName());
        newProduct.setValue(productDTO.getValue());
        newProduct.setPublicationDate(LocalDateTime.now());
        newProduct.setLimitedDate(LocalDateTime.now().plusDays(30));
        newProduct.setDescription(productDTO.getDescription());
        newProduct.setState(State.INACTIVO);
        newProduct.setSeller(userService.getUserDataBase(productDTO.getSellerCode()));
        newProduct.setImages(imagenes);
        newProduct.setCategoriesList(productDTO.getCategories());

        return productRepo.save(newProduct).getIdProduct();
    }

    @Override
    public int delateProduct(int idProduct) throws Exception
    {
        Product product = null;

        if (confirmProduct(idProduct))
        {
            product = getProductBD(idProduct);
            product.setState(State.INACTIVO);
        }

        return 0;
    }

    @Override
    public int updateProduct(int idProduct, ProductDTO productDTO) throws Exception
    {
        Product product = null;
        Map<String, String> imagenes = productDTO.getImagenes().stream().collect(
                Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

        if (confirmProduct(idProduct))
        {
            product = getProductBD(idProduct);

            product.setIdProduct(idProduct);
            product.setName(productDTO.getName());
            product.setValue(productDTO.getValue());
            product.setDescription(productDTO.getDescription());
            product.setImages(imagenes);
            product.setCategoriesList(productDTO.getCategories());

            return productRepo.save(product).getIdProduct();
        }

        return 0;
    }

    @Override
    public int updateForState(int idProduct, State state) throws Exception
    {
        Product product = null;

        if (confirmProduct(idProduct))
        {
            product = getProductBD(idProduct);
            product.setState(state);

            return productRepo.save(product).getIdProduct();
        }

        return 0;
    }

    @Override
    public ProductGetDTO getProduct(int idProduct) throws Exception
    {
        ProductGetDTO productGetDTO = convertProduct(getProductBD(idProduct));

        return productGetDTO;
    }

    @Override
    public Product getProductBD(int idProduct) throws Exception
    {
        Optional<Product> product = productRepo.findById(idProduct);

        if (product.isEmpty())
        {
            throw new Exception("El producto con el código " + idProduct + " no existe en la base de datos");
        }

        return product.get();
    }

    @Override
    public List<ProductGetDTO> listProductForCategorie(Categories categories) throws Exception
    {
        List<ProductGetDTO> lstAnswer = new ArrayList<>();
        List<Product> lstProduct = productRepo.getProductCategories(categories);

        if (lstProduct != null && lstProduct.size() > 0)
        {
            lstProduct.forEach(product -> {
                lstAnswer.add(convertProduct(product));
            });
        }

        return lstAnswer;
    }

    @Override
    public List<ProductGetDTO> listProductUser(int idCard) throws Exception
    {
        List<ProductGetDTO> lstAnswerProductUser = new ArrayList<>();
        List<Product> lstProduct = productRepo.getProductUsers(idCard);

        if (lstProduct != null && lstProduct.size() > 0)
        {
            lstProduct.forEach(product -> {
                lstAnswerProductUser.add(convertProduct(product));
            });
        }

        return lstAnswerProductUser;
    }

    @Override
    public List<ProductGetDTO> listProductFavUser(int idCard) throws Exception
    {
        List<ProductGetDTO> lstAnswerProduct = new ArrayList<>();
        User user = userService.getUserDataBase(idCard);
        List<Product> lstProducts = productRepo.getProductsFavs(user);

        if (lstProducts != null && lstProducts.size() > 0 )
        {
            lstProducts.forEach(product -> {
                lstAnswerProduct.add(convertProduct(product));
            });
        }

        return lstAnswerProduct;
    }

    @Override
    public List<ProductGetDTO> listProductPrices(double priceMin, double priceMax) throws Exception
    {
        List<ProductGetDTO> lstAnswerProductForPrices = new ArrayList<>();
        List<Product> lstProducts = productRepo.getProductRangePrice(priceMin,priceMax);

        if (lstProducts != null && lstProducts.size() > 0)
        {
            lstProducts.forEach(product -> {
                lstAnswerProductForPrices.add(convertProduct(product));
            });
        }

        return lstAnswerProductForPrices;
    }

    @Override
    public List<ProductGetDTO> listProductForNome(String name)
    {
        List<ProductGetDTO> lstAnswerProductForNames = new ArrayList<>();
        List<Product> lstProducts = productRepo.getProductName(name);

        if (lstProducts != null && lstProducts.size() > 0)
        {
            lstProducts.forEach(product -> {
                lstAnswerProductForNames.add(convertProduct(product));
            });
        }

        return lstAnswerProductForNames;
    }

    @Override
    public List<ProductGetDTO> convertLstProduct(List<Product> products)
    {
        List<ProductGetDTO> lstAnswerProducts = new ArrayList<>();

        products.forEach(product -> {
            lstAnswerProducts.add(convertProduct(product));
        });

        return lstAnswerProducts;
    }

    @Override
    public List<ProductGetDTO> productosModeador() {
        List<Product> productos = productRepo.productosModerador();
        List<ProductGetDTO> productsGETDTO = new ArrayList<>();

        productos.forEach(product -> {
            productsGETDTO.add(convertProduct(product));
        });

        return  productsGETDTO;
    }

    private ProductGetDTO convertProduct(Product product)
    {
        List<ImgDTO> lstImagenes = product.getImages().entrySet().stream().map(x -> {
            return new ImgDTO(x.getKey(), x.getValue());
        }).collect(Collectors.toList());

        ProductGetDTO productGetDTO = new ProductGetDTO(
                product.getIdProduct(),
                product.getName(),
                product.getValue(),
                product.getPublicationDate(),
                product.getLimitedDate(),
                product.getDescription(),
                product.getState(),
                product.getSeller().getIdCard(),
                lstImagenes,
                product.getCategoriesList()
        );

        return productGetDTO;
    }

    private boolean confirmProduct(int idProduct) throws Exception {
        boolean search = productRepo.existsById(idProduct);

        if (!search)
        {
            throw new Exception("El código " + idProduct + " no esta asociado a ningún producto");
        }

        return search;
    }
}