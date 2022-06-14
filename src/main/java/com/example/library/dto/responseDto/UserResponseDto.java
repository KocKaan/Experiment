package com.example.library.dto.responseDto;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private Date date;
    private String district;
    private String city;
}

