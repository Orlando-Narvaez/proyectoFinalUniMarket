package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.UserDTO;
import co.edu.uniquindio.unimarket.dto.UserGetDTO;
import co.edu.uniquindio.unimarket.model.User;

import java.util.List;

public interface UserService
{
    int createUser(UserDTO userDTO)  throws Exception;

    int updateUser(int idCard, UserDTO userDTO) throws Exception;

    UserGetDTO getUser(int idCard) throws Exception;

    List<UserGetDTO> getUsers() throws Exception;

    boolean createProductFavUser(User user) throws Exception;

    User getUserDataBase(int idCard) throws Exception;
}