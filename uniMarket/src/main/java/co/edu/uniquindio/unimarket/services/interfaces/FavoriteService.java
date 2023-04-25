package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.FavoriteDTO;

public interface FavoriteService
{
    boolean createFavorite(FavoriteDTO favoriteDTO) throws Exception;

    boolean delateFavorite(FavoriteDTO favoriteDTO) throws Exception;
}