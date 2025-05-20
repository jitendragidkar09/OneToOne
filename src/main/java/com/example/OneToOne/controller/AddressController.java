package com.example.OneToOne.controller;

import com.example.OneToOne.entity.Address;
import com.example.OneToOne.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Addresss")
public class AddressController {
    private final AddressService AddressService;

    public AddressController(AddressService AddressService) {
        this.AddressService = AddressService;
    }

    @PostMapping
    public Address postAddress(@RequestBody Address Address){
        return AddressService.createAddress(Address);
    }

    @GetMapping(value = "/{AddressId}")
    public Address getAddressById(@PathVariable Integer AddressId){
        Optional<Address> Address = AddressService.findAddressById(AddressId);
        Address Address1 = Address.orElseThrow(() -> new RuntimeException("User with given id is not found"));
        return Address1;
    }

    @DeleteMapping("/{AddressId}")
    public void deleteAddress(@PathVariable Integer AddressId){
        AddressService.removeAddressById(AddressId);
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address Address){
        Address Address1 = AddressService.updateAddress(Address);
        return Address1;
    }
}
