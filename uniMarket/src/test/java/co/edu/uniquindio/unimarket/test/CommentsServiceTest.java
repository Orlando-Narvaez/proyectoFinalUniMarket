package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.AddressGetDTO;
import co.edu.uniquindio.unimarket.dto.CommentsDTO;
import co.edu.uniquindio.unimarket.dto.CommentsGetDTO;
import co.edu.uniquindio.unimarket.services.interfaces.CommentsService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

@SpringBootTest
@Transactional
public class CommentsServiceTest
{
    @Autowired
    private CommentsService commentsService;

    @org.junit.Test
    @Sql("classpath:dataset.sql")
    public void createComment()
    {
        try {
            int id = commentsService.createComment(new CommentsDTO(
                    "Buen producto",
                    1,
                    2
            ));

            Assertions.assertNotEquals(0, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listComments() {
        try {
            List<CommentsGetDTO> lstComments = commentsService.listComments(3);

            Assertions.assertEquals(1, lstComments.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getComment()
    {
        try {
            List<CommentsGetDTO> lstComments = (List<CommentsGetDTO>) commentsService.getComment(3);

            Assertions.assertNotEquals(0, lstComments.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}