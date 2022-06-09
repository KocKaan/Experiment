package com.example.library.service;

import com.example.library.exception.UserNotFoundException;
import com.example.library.model.Address;
import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll () {
        return userRepository.findAll();
    }

    public User add(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User getUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User id not found: "+userId));

    }

    public List<User> findAllByAddress_City(String cityName){
        return userRepository.findAllByAddress_City(cityName);
    }


}
