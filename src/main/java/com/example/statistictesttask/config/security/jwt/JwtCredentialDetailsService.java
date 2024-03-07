package com.example.statistictesttask.config.security.jwt;

import com.example.statistictesttask.exceptions.notfound.NotFoundException;
import com.example.statistictesttask.persistence.entity.UserEntity;
import com.example.statistictesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtCredentialDetailsService implements UserDetailsService {

    @Lazy
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userService.getByEmail(username);

        if (userEntity == null) {
            throw new NotFoundException("User with email: " + username + " not found.");
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
    }
}
