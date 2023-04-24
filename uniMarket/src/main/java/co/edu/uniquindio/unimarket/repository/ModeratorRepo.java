package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepo extends JpaRepository<Moderator, Integer>
{
}