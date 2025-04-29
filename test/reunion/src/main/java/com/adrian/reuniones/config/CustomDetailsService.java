package com.adrian.reuniones.config;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


 
@Service
public class CustomDetailsService implements UserDetailsService {
    

   @Override
    public UserDetails loadUserByUsername(String username) {
        User user = findUserbyUername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return (UserDetails) user;
    }

    private User findUserbyUername(String username) {
        if(username.equalsIgnoreCase("admin")) {
        return new User();
        }
        return null;
    }
}



