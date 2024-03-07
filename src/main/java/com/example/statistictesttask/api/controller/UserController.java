package com.example.statistictesttask.api.controller;

import com.example.statistictesttask.api.dto.UserDto;
import com.example.statistictesttask.mapper.UserMapper;
import com.example.statistictesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password) {

        return userService.login(email, password);
    }

    @PostMapping("/registration")
    public ResponseEntity registration(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestBody UserDto userDto) {

        return userService.registration(email, password, userMapper.mapDtoToEntity(userDto));
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userMapper.mapListEntityToListDto(userService.getAllUsers());
    }

}
