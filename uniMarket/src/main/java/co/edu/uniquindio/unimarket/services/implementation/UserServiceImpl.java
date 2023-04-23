package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.UserDTO;
import co.edu.uniquindio.unimarket.dto.UserGetDTO;
import co.edu.uniquindio.unimarket.model.User;
import co.edu.uniquindio.unimarket.repository.UserRepo;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserServiceImpl implements UserService
{

    private  final UserRepo userRepo;
    @Override
    public int createUser(UserDTO userDTO) throws Exception
    {
        User search = userRepo.searchUser(userDTO.getEmail());

        if(search!=null){
            throw new Exception("El correo "+userDTO.getEmail()+" ya está en uso");
        }

        User user = convert(userDTO);
        return userRepo.save(user).getIdUser();
    }

    @Override
    public UserDTO updateUser(int idUser, UserDTO userDTO) throws Exception
    {
        validateExists(idUser);

        User user = convert(userDTO);
        user.setIdUser(user.getIdUser());

        return convert(userRepo.save(user));
    }

    @Override
    public int deleteUser(int idUser) throws Exception {
        return 0;
    }

    @Override
    public UserGetDTO getUser(int idUser) throws Exception
    {
        save = userRepo.findById(idUser);
        if(save.isEmpty())
        {
            throw new Exception("El código "+idUser+" no está asociado a ningún cliente");
        }
        return convert( save.get() );
    }
    @Override
    public List<UserGetDTO> listUser()
    {
        return convertList( userRepo.findAll() );
    }

    private void validateExists(int idUser) throws Exception{
        boolean exists = userRepo.existsById(idUser);

        if( !exists ){
            throw new Exception("El código "+idUser+" no está asociado a ningún usuario");
        }
    }

    private User convert(UserDTO userDTO)
    {

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAddress(userDTO.getAddress());
        user.setNumPhone(userDTO.getPhoneNumber());

        return user;
    }

    private UserGetDTO convert(User user)
    {
        return new UserGetDTO(
                User.getCode(),
                User.getName(),
                User.getEmail(),
                User.getAddress(),
                User.getPhoneNumber());

    }
    private List<UserGetDTO> convertList(List<User> list)
    {
        List<UserGetDTO> answer = new ArrayList<>();
        for(User u : list)
        {
            answer.add( convert(u) );
        }
        return answer;
    }
}
