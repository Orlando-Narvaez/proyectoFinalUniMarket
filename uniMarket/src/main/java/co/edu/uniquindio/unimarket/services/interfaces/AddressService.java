package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.AddressDTO;
import co.edu.uniquindio.unimarket.dto.AddressGetDTO;
import co.edu.uniquindio.unimarket.model.Address;
import java.util.List;

public interface AddressService
{
    int createAddress(AddressDTO addressDTO)  throws Exception;

    int upsdateAddress(int id, AddressDTO addressDTO) throws Exception;

    boolean delateAddress(int id) throws Exception;

    List<AddressGetDTO> getAddressUser(String idCardUser) throws Exception;
    Address getAddresBD(int id) throws Exception;
    AddressGetDTO convertAddress(Address address);
}