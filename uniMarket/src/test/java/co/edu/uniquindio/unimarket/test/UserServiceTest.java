package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ProductGetDTO;
import co.edu.uniquindio.unimarket.dto.UserDTO;
import co.edu.uniquindio.unimarket.dto.UserGetDTO;
import co.edu.uniquindio.unimarket.model.entidad.State;
import co.edu.uniquindio.unimarket.model.entidad.User;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
@SpringBootTest
@Transactional
public class UserServiceTest
{
    @Autowired
    private UserService userService;

    @Test
    @Sql("classpath:dataset.sql")
    public void registerUserTest()
    {
        try {
            UserDTO userDTO = new UserDTO(
                    "723",
                    "JulianQ",
                    "JulianQ@gmail.com",
                    "1234",
                    "Br montevideo Mz 6 casa 8",
                    "3128190284");

            String idCard = userService.registerUser(userDTO);

            Assertions.assertNotEquals("", idCard);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void updateUser()
    {
        try {
            UserGetDTO User = userService.getUser("1094936382");
            User.setName("JulianQ");

            String idCardUpdate = userService.updateUser(User.getIdCard(), new UserDTO(
                    User.getIdCard(),
                    User.getName(),
                    User.getEmail(),
                    User.getNumPhone(),
                    User.getUserName(),
                    User.getPassword(),
                    ));

            User = userService.getUser(idCardUpdate);

            Assertions.assertNotEquals("Julian Andres Quiroga Ballen", User.getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        @Test
        @Sql("classpath:dataset.sql")
        public void getUser() {
        try {
            UserGetDTO UserGetDTO = userService.getUser("1094936382");

            Assertions.assertEquals("JulianQB", UserGetDTO.getPassword());
        } catch (Exception exception){
            exception.printStackTrace();
        }
        @Test
        @Sql("classpath:dataset.sql")
        public void obtenerUsuarios() {
            try {
                List<UserGetDTO> lstUser = userService.getUser();

                Assertions.assertNotEquals(0, listUser.size());
            } catch (Exception exception){
                exception.printStackTrace();
            }
        }
        @Test
        @Sql("classpath:dataset.sql")
        public void changePassword()
        {
            try {
                boolean answer = userService.changePassword("jaquirogab@uqvirtual.com", "1234");

                Assertions.assertTrue(answer);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    }