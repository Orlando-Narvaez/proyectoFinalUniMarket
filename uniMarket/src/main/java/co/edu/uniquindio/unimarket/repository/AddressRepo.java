package co.edu.uniquindio.unimarket.repository;

import co.edu.uniquindio.unimarket.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer>
{
    @Query("select a from Address a where a.user.idCard= :idCardUser")
    List<Address> getAddressUser(String idCardUser);
}