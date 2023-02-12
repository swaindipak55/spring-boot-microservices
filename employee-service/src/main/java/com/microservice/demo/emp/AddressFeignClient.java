package com.microservice.demo.emp;

import com.microservice.demo.emp.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service")
public interface AddressFeignClient {

    @GetMapping("address/{id}")
    public Address getAddressById(@PathVariable Integer id);
}
