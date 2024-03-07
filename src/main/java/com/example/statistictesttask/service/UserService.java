package com.example.statistictesttask.service;

import com.example.statistictesttask.persistence.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity registration(String email, String password, UserEntity user);

    ResponseEntity login(String email, String password);

    UserEntity getByEmail(String email);

    List<UserEntity> getAllUsers();

}
