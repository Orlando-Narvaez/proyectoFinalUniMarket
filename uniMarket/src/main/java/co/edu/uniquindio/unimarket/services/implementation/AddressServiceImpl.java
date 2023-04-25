package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.dto.AddressDTO;
import co.edu.uniquindio.unimarket.dto.AddressGetDTO;
import co.edu.uniquindio.unimarket.model.Address;
import co.edu.uniquindio.unimarket.model.User;
import co.edu.uniquindio.unimarket.repository.AddressRepo;
import co.edu.uniquindio.unimarket.services.interfaces.AddressService;
import co.edu.uniquindio.unimarket.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService
{
    private final AddressRepo addressRepo;
    private final UserService userService;

    @Override
    public int createAddress(AddressDTO addressDTO) throws Exception
    {
        Address newAddress = new Address();
        User user = userService.getUserDataBase(addressDTO.getIdCardUser());

        if (user != null)
        {
            newAddress.setDescripcion(addressDTO.getDescripcion());
            newAddress.setPostalCod(addressDTO.getPostalCod());
            newAddress.setUser(user);

            return addressRepo.save(newAddress).getId();
        }

        throw new Exception("El usuario identificado con " + addressDTO.getIdCardUser() + " no exist en la base de datos");
    }

    @Override
    public int upsdateAddress(int id, AddressDTO addressDTO) throws Exception
    {
        Address address = getAddresBD(id);
        if (address != null) {
            address.setId(id);
            address.setDescripcion(addressDTO.getDescripcion());
            address.setPostalCod(addressDTO.getPostalCod());

            return addressRepo.save(address).getId();
        }

        return 0;
    }

    @Override
    public boolean delateAddress(int id) throws Exception
    {
        Address address = getAddresBD(id);
        if (address != null) {
            addressRepo.delete(address);
            return true;
        }
        return false;
    }

    @Override
    public List<AddressGetDTO> getAddressUser(String idCardUser) throws Exception
    {
        List<AddressGetDTO> lstAnswerAddress = new ArrayList<>();
        List<Address> lstAddress = (List<Address>) addressRepo.getAddressUser(idCardUser);

        if (lstAddress != null && lstAddress.size() > 0) {
            lstAddress.forEach(address -> {
                lstAnswerAddress.add(convertAddress(address));
            });
        }
        return null;
    }

    @Override
    public Address getAddresBD(int id) throws Exception
    {
        Optional<Address> address = addressRepo.findById(id);
        if (address.isEmpty()) {
            throw new Exception("La dirección asociada al código " + address + " no existe");
        }

        return address.get();
    }

    @Override
    public AddressGetDTO convertAddress(Address address)
    {
        AddressGetDTO addressGetDTO = new AddressGetDTO(
                address.getId(),
                address.getDescripcion(),
                address.getPostalCod(),
                address.getUser().getIdCard()
        );

        return addressGetDTO;
    }
}