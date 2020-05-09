package com.alex.security;

import com.alex.model.User;
import com.alex.security.jwt.JwtUser;
import com.alex.security.jwt.JwtUserFactory;
import com.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Alexandr Chesnokov
 * @project CarShowRoomApp
 */

@Service

public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        System.out.println("IN loadUserByUsername - user with username " + username + " successfully loaded");


        return jwtUser;
    }
}
