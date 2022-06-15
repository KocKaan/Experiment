package com.example.library.controller;

import com.example.library.model.Address;
import com.example.library.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @PostMapping
    public Address add(@RequestBody Address address){
        return addressService.add(address);
    }

}
