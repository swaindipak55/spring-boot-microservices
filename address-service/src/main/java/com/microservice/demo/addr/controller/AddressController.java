package com.microservice.demo.addr.controller;

import com.microservice.demo.addr.model.Address;
import com.microservice.demo.addr.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService employeeService;

    @PostMapping("address")
    public Address addAddress(@RequestBody Address employee) {
        return employeeService.addAddress(employee);
    }

    @GetMapping("address/{id}")
    public Address getAddressById(@PathVariable Integer id) {
        return employeeService.getAddressById(id);
    }

    @GetMapping("address")
    public List<Address> getAllAddresses() {
        return employeeService.getAllAddresses();
    }
}
