package com.example.library.service;

import com.example.library.dto.requestDto.UserRequestDto;
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

    public User add(UserRequestDto userRequestDto) {

        User  user= new User();
        user.setName(userRequestDto.getName());


        if(userRequestDto.getAddressId() == null){
            throw new IllegalArgumentException("you need an id an on existing address ");
        }else{
            Address addressById= addressService.getAddressById(userRequestDto.getAddressId());
            user.setAddress(addressById);
        }
        return userRepository.saveAndFlush(user);
    }


    public User getUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User id not found: "+userId));
    }

    public User updateUserById(User userRequest,Long userId) throws UserNotFoundException{
        User userToEdit = getUserById(userId);

        userToEdit.setName(userRequest.getName());
        userToEdit.setDate(userRequest.getDate());

        if(userRequest.getAddress() != null) {

            Address address= addressService.getAddressById(userRequest.getAddress().getId());
            userToEdit.setAddress(address);
        }
        return userToEdit;

    }

    public List<User> findAllByAddress_City(String cityName){
        return userRepository.findAllByAddress_City(cityName);
    }


}
