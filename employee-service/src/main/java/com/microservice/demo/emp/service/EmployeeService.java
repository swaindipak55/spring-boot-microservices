package com.microservice.demo.emp.service;

import com.microservice.demo.emp.AddressFeignClient;
import com.microservice.demo.emp.DepartmentFeignClient;
import com.microservice.demo.emp.dao.EmployeeRepository;
import com.microservice.demo.emp.dto.EmployeeDto;
import com.microservice.demo.emp.model.Address;
import com.microservice.demo.emp.model.Department;
import com.microservice.demo.emp.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Value("${server.port}")
    private String servicePort;

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final AddressFeignClient addressFeignClient;
    private final DepartmentFeignClient departmentFeignClient;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeDto getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Employee[%s] not found", id)));
        Integer addressId = employee.getAddressId();
        Integer departmentId = employee.getDepartmentId();

        Department department = restTemplate.getForObject("http://department-service/department/{id}", Department.class, departmentId);
        Address address = webClient.get()
                .uri("http://address-service/address/{id}", addressId)
                .retrieve()
                .bodyToMono(Address.class)
                .block();
        //Address address = restTemplate.getForObject("http://address-service/address/{id}", Address.class, addressId);

        return EmployeeDto.builder()
                .empId(employee.getEmpId())
                .email(employee.getEmail())
                .name(employee.getName())
                .empServicePort(servicePort)
                .addressId(addressId)
                .address(Objects.requireNonNull(address).getAddress())
                .addrServicePort(address.getServicePort())
                .departmentId(departmentId)
                .departName(Objects.requireNonNull(department).getDepartmentName())
                .deptServicePort(department.getServicePort())
                .build();
    }

    public EmployeeDto getEmployeeById2(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Employee[%s] not found", id)));
        Integer addressId = employee.getAddressId();
        Integer departmentId = employee.getDepartmentId();
        Address address = addressFeignClient.getAddressById(addressId);
        Department department = departmentFeignClient.getDepartmentById(departmentId);
        return EmployeeDto.builder()
                .empId(employee.getEmpId())
                .email(employee.getEmail())
                .name(employee.getName())
                .empServicePort(servicePort)
                .addressId(addressId)
                .address(Objects.requireNonNull(address).getAddress())
                .addrServicePort(address.getServicePort())
                .departmentId(departmentId)
                .departName(Objects.requireNonNull(department).getDepartmentName())
                .deptServicePort(department.getServicePort())
                .build();
    }
}
