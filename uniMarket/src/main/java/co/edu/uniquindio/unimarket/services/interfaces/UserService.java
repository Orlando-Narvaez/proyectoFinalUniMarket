package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.UserDTO;
import co.edu.uniquindio.unimarket.dto.UserGetDTO;
import co.edu.uniquindio.unimarket.model.User;

public interface UserService
{
    int createUser(UserDTO userDTO)  throws Exception;

    UserDTO updateUser(int idUser, UserDTO userDTO) throws Exception;

    int deleteUser(int idUser) throws Exception;

    UserGetDTO getUser(int idUser) throws Exception;

}