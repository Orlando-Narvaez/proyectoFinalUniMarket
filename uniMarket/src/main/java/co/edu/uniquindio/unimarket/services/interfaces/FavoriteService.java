package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.FavoriteDTO;

public interface FavoriteService
{
    int createFavorite(FavoriteDTO favoriteDTO) throws Exception;

    Boolean delateFavorite(int idUser, int idProduct) throws Exception;
}