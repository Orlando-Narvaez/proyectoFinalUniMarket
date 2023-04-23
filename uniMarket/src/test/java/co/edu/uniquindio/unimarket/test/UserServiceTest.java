package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@Transactional
public class UserServiceTest
{
    @Autowired
    private UserService userService;

    @Test
    public void register() throws Exception
    {
        UserPostDTO userPostDTO = new UserPostDTO(

                "Pepito Perez",
                "pepe@email.com",
                "1234",
                "Calle 12 # 1 - 5",
                "7402324");

//Guardamos el registro usando el método del servicio
        int new = userService.registerUser(userPostDTO);
//Comprobamos que sí haya quedado guardado. Si se guardó debe retornar el código (no 0).
        Assertions.assertNotEquals(0, new);
    }
}