package com.microservice.demo.addr.service;

import com.microservice.demo.addr.dao.AddressRepository;
import com.microservice.demo.addr.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    @Value("${server.port}")
    private String servicePort;

    public final AddressRepository addressRepository;

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(Integer id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Address[%s] not found", id)));
        address.setServicePort(servicePort);
        return address;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
