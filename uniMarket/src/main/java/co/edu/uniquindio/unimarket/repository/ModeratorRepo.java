package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Moderator;
import co.edu.uniquindio.unimarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ModeratorRepo extends JpaRepository<Moderator, Integer>
{
    @Query("select m from Moderator m where m.email = :email")
    Moderator findByEmail(String email);
}
