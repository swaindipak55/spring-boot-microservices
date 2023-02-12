package com.microservice.demo.addr.service;

import com.microservice.demo.addr.dao.AddressRepository;
import com.microservice.demo.addr.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    public final AddressRepository addressRepository;

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Address[%s] not found", id)));
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
