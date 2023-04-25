package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.FavoriteDTO;
import co.edu.uniquindio.unimarket.model.Product;
import co.edu.uniquindio.unimarket.model.User;
import co.edu.uniquindio.unimarket.services.interfaces.FavoriteService;
import co.edu.uniquindio.unimarket.services.interfaces.ProductService;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements FavoriteService
{
    private final ProductService productService;
    private final UserService userService;

    @Override
    public boolean createFavorite(FavoriteDTO favoriteDTO) throws Exception
    {
        User user = userService.getUserDataBase(favoriteDTO.getIdUser());
        Product product = productService.getProductBD(favoriteDTO.getIdProduct());

        if (user.getFavorite().contains(product))
        {
            user.getFavorite().add(product);
            return userService.createProductFavUser(user);
        }

        return false;
    }

    @Override
    public boolean delateFavorite(FavoriteDTO favoriteDTO) throws Exception
    {
        User user = userService.getUserDataBase(favoriteDTO.getIdUser());
        Product product = productService.getProductBD(favoriteDTO.getIdProduct());

        if (user.getFavorite().contains(product))
        {
            user.getFavorite().remove(product);
            return userService.createProductFavUser(user);
        }

        throw new Exception("EL producto con él código "+favoriteDTO+ " no se encuentra en la lista de favoritos");
    }
}
