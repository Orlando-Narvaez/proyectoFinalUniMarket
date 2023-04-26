package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.UserGetDTO;
import co.edu.uniquindio.unimarket.dto.UserPostDTO;
import co.edu.uniquindio.unimarket.model.User;
import co.edu.uniquindio.unimarket.repository.UserPostRepo;
import co.edu.uniquindio.unimarket.services.exceptions.AttributeException;
import co.edu.uniquindio.unimarket.services.interfaces.UserPostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import static io.jsonwebtoken.lang.Classes.isAvailable;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserPostServiceImpl implements UserPostService
{
    private final UserPostRepo userPostRepo;
    @Override
    public int registerUser(UserPostDTO UserDTO) throws Exception
    {
        if(!isAvailable(UserDTO.getEmail()))
        {
            throw new AttributeException("El correo "+UserDTO.getEmail()+" ya está en uso");
        }
        User user = new User();
        user.setName( UserDTO.getName() );
        user.setEmail( UserDTO.getEmail() );
        user.setAddress( UserDTO.getAddress() );
        user.setNumPhone(UserDTO.getPhoneNumber());
        user.setPassword( UserDTO.getPassword() );
        return userPostRepo.save( user ).getIdUser();
    }

    @Override
    public int updateUser(int code, UserGetDTO UserDTO) throws Exception
    {
        Optional<User> register = userPostRepo.findById(code);
        if(register.isEmpty()){
            throw new Exception("El cliente no existe");
        }
        User saved = register.get();
        saved.setName( UserDTO.getName() );
        saved.setEmail( UserDTO.getEmail() );
        saved.setAddress( UserDTO.getAddress() );
        saved.setNumPhone(UserDTO.getPhoneNumber());
        //return convert( userRepo.save(saved) );
        return 0;
    }
}
