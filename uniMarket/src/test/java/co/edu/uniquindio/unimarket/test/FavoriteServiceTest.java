package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.FavoriteDTO;
import co.edu.uniquindio.unimarket.services.interfaces.FavoriteService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class FavoriteServiceTest
{
    @Autowired
    private FavoriteService favoriteService;
    @Test
    @Sql("classpath:dataset.sql")
    public void createFavorite()
    {
        try {
            boolean answer = favoriteService.createFavorite(new FavoriteDTO(
                    1094978017,
                    3
            ));

            Assertions.assertTrue(answer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delateFavorite()
    {
        try {
            boolean answer = favoriteService.delateFavorite(new FavoriteDTO(
                    1094978017,
                    3
            ));

            Assertions.assertTrue(answer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}