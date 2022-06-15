package com.example.library.dto;

import com.example.library.dto.responseDto.UserResponseDto;
import com.example.library.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class UserResponseMapper {
    public static UserResponseDto userToUserResponseDto(User user){

        UserResponseDto userResponseDto= UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .date(user.getDate())
                .district(user.getAddress().getDistrict())
                .city(user.getAddress().getCity())
                .build();

        return userResponseDto;
    }

    public static List<UserResponseDto> userToUserResponseDtos(List<User> users){
        List<UserResponseDto> userResponseDtos = users.stream()
                .map(u -> userToUserResponseDto(u)).collect(Collectors.toList());

        return userResponseDtos;
    }

}

