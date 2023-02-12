package com.microservice.demo.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private Integer empId;

    private String name;

    private String email;

    private Integer departmentId;

    private Integer addressId;

    private String address;

    private String departName;
}
