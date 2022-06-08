package com.example.library.service;

import com.example.library.model.Address;
import com.example.library.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address add(Address address){
        return addressRepository.saveAndFlush(address);
    }
}
