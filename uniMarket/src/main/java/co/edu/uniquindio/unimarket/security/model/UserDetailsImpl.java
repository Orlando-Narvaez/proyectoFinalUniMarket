package co.edu.uniquindio.unimarket.security.model;

import co.edu.uniquindio.unimarket.model.Person;
import co.edu.uniquindio.unimarket.model.Moderator;
import co.edu.uniquindio.unimarket.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
    @AllArgsConstructor
    public class UserDetailsImpl implements UserDetails
    {
        private String username, password;
        private int code;
        private Collection<? extends GrantedAuthority> authorities;
        public static UserDetailsImpl build(Person user)
        {
            List<GrantedAuthority> authorities = new ArrayList<>();
            if(user instanceof User)
            {
                authorities.add( new SimpleGrantedAuthority("CLIENTE") );
            }else if(user instanceof Moderator)
            {
                authorities.add( new SimpleGrantedAuthority("MODERADOR") );
            }
            return new UserDetailsImpl(user.getEmail(), user.getPassword(), user.getIdCard(), authorities);
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities()
        {
            return authorities;
        }
        @Override
        public String getPassword()
        {
            return password;
        }
        @Override
        public String getUsername()
        {
            return username;
        }
        public int getCode() { return code; }
        @Override
        public boolean isAccountNonExpired()
        {
            return true;
        }
        @Override
        public boolean isAccountNonLocked()
        {
            return true;
        }
        @Override
        public boolean isCredentialsNonExpired()
        {
            return true;
        }
        @Override
        public boolean isEnabled()
        {
            return true;
        }
    }

