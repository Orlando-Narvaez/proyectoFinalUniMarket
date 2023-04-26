package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepo extends JpaRepository<User,Integer>
{

}
