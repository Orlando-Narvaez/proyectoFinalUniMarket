package co.edu.uniquindio.unimarket.services.exceptions;

public class AttributeException extends Exception
{
    public AttributeException(String message)
    {
        super(message);
    }

    @Override
    public User getUser(int idUser) throws Exception
    {
        user = userRepo.findById(idUser);
        if (user.isEmpty()) {
            throw new Exception("El código " + idUser + " no está asociado a ningún cliente");
        }
        return user.get();
    }
    @Override
    public List<User> listUser()
    {
        return userRepo.findAll();
    }
    @Override
    public int updateUser(User u) throws Exception
    {
        save = userRepo.findById(u.getIduser());
        if(save.isEmpty())
        {
            throw new Exception("El cliente no existe");
        }
        return userRepo.save( c ).getIduser();
    }
    @Override
    public void deleteUser(int Iduser) throws Exception
    {
        user = userRepo.findById(idUser);
        if(user.isEmpty())
        {
            throw new Exception("El código "+codigo+" no está asociado a ningún cliente");
        }
        userRepo.delete( user );
    }
    }

