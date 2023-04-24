package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
    @Query("select u from User u where u.email = :email")
    User findByEmail(String email);
}
