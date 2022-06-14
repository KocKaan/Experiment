package com.example.library.service;

import com.example.library.dto.mapper;
import com.example.library.dto.requestDto.UserRequestDto;
import com.example.library.dto.responseDto.UserResponseDto;
import com.example.library.exception.UserNotFoundException;
import com.example.library.model.Address;
import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressService addressService;

    public UserService(UserRepository userRepository, AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }


    public List<User> findAll () {
        return userRepository.findAll();
    }

    public UserResponseDto add(UserRequestDto userRequestDto) {

        User user= new User();
        user.setName(userRequestDto.getName());


        if(userRequestDto.getAddressId() == null){
            throw new IllegalArgumentException("you need an id an on existing address ");
        }else{
            Address addressById= addressService.getAddressById(userRequestDto.getAddressId());
            user.setAddress(addressById);
        }
        User resultUser= userRepository.saveAndFlush(user);

        return mapper.userToUserResponseDto(resultUser);
    }


    public User getUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User id not found: "+userId));
    }

    public UserResponseDto updateUserById(UserRequestDto userRequest,Long userId) throws UserNotFoundException{
        User userToEdit = getUserById(userId);

        userToEdit.setName(userRequest.getName());

        if(userRequest.getAddressId() != null) {

            Address address= addressService.getAddressById(userRequest.getAddressId());
            userToEdit.setAddress(address);
        }

        User updatedUser= userRepository.saveAndFlush(userToEdit);
        return mapper.userToUserResponseDto(updatedUser);
    }

    public UserResponseDto updateUserName(Long userId, String firstName){
        User userToEdit = getUserById(userId);
        userToEdit.setName(firstName);

        User updatedUser= userRepository.saveAndFlush(userToEdit);
        return mapper.userToUserResponseDto(updatedUser);
    }

    public List<User> findAllByAddress_City(String cityName){
        return userRepository.findAllByAddress_City(cityName);
    }


}
