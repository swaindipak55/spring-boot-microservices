package com.microservice.demo.emp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    private Integer departmentId;

    private String departmentName;

    private String servicePort;
}
