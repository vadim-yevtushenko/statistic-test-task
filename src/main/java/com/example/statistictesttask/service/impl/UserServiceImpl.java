package com.example.statistictesttask.service.impl;

import com.example.statistictesttask.config.security.jwt.JwtProvider;
import com.example.statistictesttask.mapper.UserMapper;
import com.example.statistictesttask.persistence.entity.UserEntity;
import com.example.statistictesttask.persistence.repository.UserRepository;
import com.example.statistictesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntity registration(String email, String password, UserEntity userEntity) {
        if (isUsedEmail(email)){
            throw new BadCredentialsException(String.format("User with address %s already exist.", email));
        }

        String encodedPassword = passwordEncoder.encode(password);

        userEntity.setEmail(email);
        userEntity.setPassword(encodedPassword);
        userRepository.save(userEntity);

        return ResponseEntity.ok(createResponse(email, password, userEntity));
    }

    @Override
    public ResponseEntity login(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            UserEntity credentialEntity = userRepository.findByEmail(email);

            return ResponseEntity.ok(createResponse(email, password, credentialEntity));
        }catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email or password");
        }
    }

    @Override
    public UserEntity getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    private Map<String, Object> createResponse(String email, String password, UserEntity userEntity){
        String token = jwtProvider.createToken(email, password);
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", userMapper.mapEntityToDto(userEntity));

        return response;
    }

    private boolean isUsedEmail(String email) {
        UserEntity userEntity = getByEmail(email);
        return userEntity != null;
    }

}
