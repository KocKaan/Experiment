package com.example.library.controller;

import com.example.library.dto.UserResponseMapper;
import com.example.library.dto.requestDto.UserRequestDto;
import com.example.library.dto.responseDto.UserResponseDto;
import com.example.library.model.User;
import com.example.library.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> add(@RequestBody UserRequestDto userRequestDto) {
        User user = userService.add(userRequestDto);

        UserResponseDto userResponseDto= UserResponseMapper.userToUserResponseDto(user);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserResponseDto> editUser(@RequestBody UserRequestDto editUser, @PathVariable Long id){
        User user = userService.updateUserById(editUser,id);

        UserResponseDto userResponseDto= UserResponseMapper.userToUserResponseDto(user);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}/{name}")
    public ResponseEntity<UserResponseDto> editUserName(@PathVariable Long id, @PathVariable String name){
        User user= userService.updateUserName(id, name);

        UserResponseDto userResponseDto= UserResponseMapper.userToUserResponseDto(user);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }
}
