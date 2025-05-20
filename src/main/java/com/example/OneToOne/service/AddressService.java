package com.example.OneToOne.service;

import com.example.OneToOne.entity.Address;
import com.example.OneToOne.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public Optional<Address> findAddressById(Integer addressId){
        return addressRepository.findById(addressId);
    }

    public void removeAddressById(Integer addressId){
        addressRepository.deleteById(addressId);
    }

    public Address updateAddress(Address address){
        Integer addressId = address.getAddressId();
        Address oldAddress = addressRepository.findById(addressId).get();
        oldAddress.setAddress(address.getAddress());
        Address addresss = addressRepository.save(oldAddress);
        return  addresss;
    }
}
