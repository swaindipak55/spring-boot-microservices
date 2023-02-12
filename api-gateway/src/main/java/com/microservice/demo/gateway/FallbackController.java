package com.microservice.demo.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("addressServiceFallBack")
    public String addressServiceFallback() {
        return "AddressService is talking longer than usual";
    }

    @GetMapping("employeeServiceFallBack")
    public String employeeServiceFallBack() {
        return "EmployeeService is talking longer than usual";
    }
}
