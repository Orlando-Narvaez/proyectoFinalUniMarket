package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Guarantee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GuaranteeRepo extends JpaRepository<Guarantee,Integer>
{
    @Query("select g from Guarantee g where g.user.idCard = :idCard")
    List<Guarantee> getGuaranteeUser(int idCard);
}
