package com.example.library.dto;

import com.example.library.dto.responseDto.UserResponseDto;
import com.example.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class mapper {
    public static UserResponseDto userToUserResponseDto(User user){
        UserResponseDto userResponseDto= new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setDate(user.getDate());
        userResponseDto.setDistrict(user.getAddress().getDistrict());
        userResponseDto.setCity(user.getAddress().getCity());

        return userResponseDto;
    }

    public static List<UserResponseDto> userToUserResponseDtos(List<User> users){
        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        for(User user: users){
            userResponseDtos.add(userToUserResponseDto(user));
        }
        return userResponseDtos;
    }

}

