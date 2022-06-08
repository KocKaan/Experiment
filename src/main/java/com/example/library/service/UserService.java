package com.example.library.service;

import com.example.library.model.Address;
import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll () {
        return userRepository.findAll();
    }

    public User add(User user) {
        return userRepository.saveAndFlush(user);
    }

}
