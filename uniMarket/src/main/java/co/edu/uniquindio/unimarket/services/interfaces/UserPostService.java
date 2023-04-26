package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.UserGetDTO;
import co.edu.uniquindio.unimarket.dto.UserPostDTO;

public interface UserPostService
{
    int registerUser(UserPostDTO UserDTO) throws Exception;

    int updateUser(int code, UserGetDTO UserDTO) throws Exception;
}