package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.UserDTO;
import co.edu.uniquindio.unimarket.dto.UserGetDTO;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.ArrayList;
import java.util.List;
@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @Sql("classpath:dataset.sql")
    public void registerUserTest()
    {
        try {
            UserDTO userDTO = new UserDTO(
                    7231,
                    "Julian Q",
                    "JulianQ@gmail.com",
                    "1234",
                    "Br montevideo Mz 6 casa 8",
                    "3128190284");

            int idCard = userService.createUser(userDTO);

            Assertions.assertNotEquals("", idCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void updateUser() {
        try {
            UserGetDTO user = userService.getUser(1094936382);
            user.setName("JulianQ");

            int idCardUpdate = userService.updateUser(user.getIdCard(), new UserDTO(
                    user.getIdCard(),
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getAddress(),
                    user.getPhoneNumber()
            ));

            user = userService.getUser(idCardUpdate);

            Assertions.assertNotEquals("Julian Andres Quiroga Ballen", user.getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getUser()
    {
        try {
            UserGetDTO userGetDTO = userService.getUser(1094936382);

            Assertions.assertEquals("JulianQB", userGetDTO.getPassword());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getUsers ()
    {
        try
        {
            List<UserGetDTO> lstUser = userService.getUsers();

            Assertions.assertNotEquals(0, lstUser.size());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}