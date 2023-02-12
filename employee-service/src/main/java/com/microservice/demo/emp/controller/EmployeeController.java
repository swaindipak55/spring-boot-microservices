package com.microservice.demo.emp.controller;

import com.microservice.demo.emp.dto.EmployeeDto;
import com.microservice.demo.emp.model.Employee;
import com.microservice.demo.emp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("employee/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("employee/feign/{id}")
    public EmployeeDto getEmployeeById2(@PathVariable Integer id) {
        return employeeService.getEmployeeById2(id);
    }

    @GetMapping("employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
