package com.example.library.controller;

import com.example.library.dto.requestDto.UserRequestDto;
import com.example.library.model.User;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User add(@RequestBody UserRequestDto userRequestDto) {
        return userService.add(userRequestDto);
    }

    @PostMapping("/edit/{id}")
    public User editUser(@RequestBody User editUser, @PathVariable Long id){
        return userService.updateUserById(editUser,id);

    }
}
