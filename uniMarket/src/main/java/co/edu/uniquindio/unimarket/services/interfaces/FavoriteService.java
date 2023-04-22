package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.FavoriteDTO;

public interface FavoriteService
{
    void createFavorite(FavoriteDTO favoriteDTO) throws Exception;

    void eliminarFavorito(int idUser, int idProduct) throws Exception;
}