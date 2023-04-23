package co.edu.uniquindio.unimarket.security.services;

import co.edu.uniquindio.unimarket.model.Moderator;
import co.edu.uniquindio.unimarket.model.User;
import co.edu.uniquindio.unimarket.repository.ModeratorRepo;
import co.edu.uniquindio.unimarket.repository.UserRepo;
import co.edu.uniquindio.unimarket.security.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModeratorRepo adminRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        User user = userRepo.findByEmail(email);
        if(user != null)
        {
            Moderator admin = adminRepo.findByEmail(email);
            if(admin!= null)
                throw new UsernameNotFoundException("El usuario no existe");
            return UserDetailsImpl.build(admin);
        }else
        {
            return UserDetailsImpl.build(user);
        }
    }
}
