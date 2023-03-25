package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.UserDTO;
import co.edu.uniquindio.unimarket.dto.UserGetDTO;
import co.edu.uniquindio.unimarket.model.User;
public interface UserService
{
    int createUser(UserDTO userDTO)  throws Exception;

    int updateUser(int userCode, UserDTO userDTO) throws Exception;

    int deleteUser(int userCode) throws Exception;

    UserGetDTO getUser(int userCode) throws Exception;
}
