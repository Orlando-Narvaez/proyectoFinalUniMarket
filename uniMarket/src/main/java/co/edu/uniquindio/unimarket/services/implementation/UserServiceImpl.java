package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.ProductGetDTO;
import co.edu.uniquindio.unimarket.dto.UserDTO;
import co.edu.uniquindio.unimarket.dto.UserGetDTO;
import co.edu.uniquindio.unimarket.model.User;
import co.edu.uniquindio.unimarket.repository.UserRepo;
import co.edu.uniquindio.unimarket.services.interfaces.ProductService;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public int createUser(UserDTO userDTO) throws Exception
    {
        User newUser = new User();
        newUser.setUserName(userDTO.getEmail());
        newUser.setName(userDTO.getName());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setAddress(userDTO.getAddress());
        newUser.setNumPhone(userDTO.getPhoneNumber());
        newUser.setCreationDate(LocalDateTime.now());
        newUser.setBirthDate(userDTO.getBirthDate());

        return userRepo.save(newUser).getIdCard();
    }

    @Override
    public int updateUser(int idCard, UserDTO userDTO) throws Exception
    {
        User user = getUserDataBase(idCard);
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAddress(userDTO.getAddress());
        user.setNumPhone(userDTO.getPhoneNumber());

        return userRepo.save(user).getIdCard();
    }

    @Override
    public UserGetDTO getUser(int idCard) throws Exception
    {
        return convertUser(getUserDataBase(idCard));
    }

    @Override
    public List<UserGetDTO> getUsers() throws Exception
    {
        List<User> lstUsers = userRepo.findAll();
        List<UserGetDTO> lstUserGetDTO = new ArrayList<>();

        if (lstUsers != null && lstUsers.size() > 0)
        {
            lstUsers.forEach(user -> {
                lstUserGetDTO.add(convertUser(user));
            });
        }

        return lstUserGetDTO;
    }

    @Override
    public int createProductFavUser(User user) throws Exception
    {
        return userRepo.save(user).getIdCard();
    }

    @Override
    public User getUserDataBase(int idCard) throws Exception
    {
        Optional<User> user = userRepo.findById(idCard);

        if (user.isEmpty())
        {
            throw new Exception("El usuario con el codigo "+idCard+" no existe");
        }

        return user.get();
    }

    private UserGetDTO convertUser(User user)
    {
        UserGetDTO userGetDTO = new UserGetDTO(
                user.getIdCard(),
                user.getIdCard(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getAddress(),
                user.getNumPhone(),
                new ArrayList<>()
        );
        return userGetDTO;
    }
}