package com.example.library.controller;

import com.example.library.dto.requestDto.UserRequestDto;
import com.example.library.dto.responseDto.UserResponseDto;
import com.example.library.model.User;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> add(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.add(userRequestDto);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserResponseDto> editUser(@RequestBody UserRequestDto editUser, @PathVariable Long id){
        UserResponseDto userResponseDto= userService.updateUserById(editUser,id);

        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}/{name}")
    public ResponseEntity<UserResponseDto> editUserName(@PathVariable Long id, @PathVariable String name){
        UserResponseDto userResponseDto= userService.updateUserName(id, name);

        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }
}
