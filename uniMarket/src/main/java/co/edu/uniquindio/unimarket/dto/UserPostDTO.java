package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
@AllArgsConstructor
@Getter
@Setter
public class UserPostDTO
{
    @NotBlank
    @Length(max = 150, message = "El nombre debe tener máximo 100 caracteres")
    private String name;
    @NotBlank
    @Email
    @Length(max = 100, message = "El correo debe tener máximo 100 caracteres")
    private String email;
    @NotBlank
    @Length(max = 50, message = "La contraseña debe tener máximo 50 caracteres")
    private String password;
    @NotBlank
    @Length(max = 100, message = "La dirección debe tener máximo 100 caracteres")
    private String address;
    @NotBlank
    @Length(max = 12, message = "El teléfono debe tener máximo 12 caracteres")
    private String phoneNumber;

    @Override
    public int registerUser(UserPostDTO UserDTO) throws Exception
    {
        if(!isAvailable(UserDTO.getEmail()))
        {
            throw new AttributeException("El correo "+UserDTO.getEmail()+" ya está en uso");
        }
        User user = new user();
        user.setName( UserDTO.getName() );
        user.setEmail( UserDTO.getEmail() );
        user.setAddress( UserDTO.getAddress() );
        user.setPhoneNumber( UserDTO.getPhoneNumber() );
        user.setPassword( UserDTO.getPassword() );
        return userRepo.save( user ).getCode();
    }

    @Override
    public int updateUser(int code, UserGetDTO UserDTO) throws Exception
    {
        Optional<User> register = userRepo.findById(code);
        if(register.isEmpty()){
            throw new Exception("El cliente no existe");
        }
        User saved = register.get();
        saved.setName( UserDTO.getName() );
        saved.setEmail( UserDTO.getEmail() );
        saved.setAddress( UserDTO.getAddress() );
        saved.setPhoneNumber( UserDTO.getPhoneNumber() );
        return convert( userRepo.save(saved) );
    }
}