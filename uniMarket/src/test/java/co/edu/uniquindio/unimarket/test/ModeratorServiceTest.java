package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.model.State;
import co.edu.uniquindio.unimarket.services.interfaces.ModeratorService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class ModeratorServiceTest
{
    @Autowired
    private ModeratorService moderatorService;

    @Test
    @Sql("classpath:dataset.sql")
    public void updateState()
    {
        try {
            boolean answer = moderatorService.updateState(3, State.INACTIVO);

            Assertions.assertTrue(answer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}