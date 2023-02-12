package com.microservice.demo.dept.service;

import com.microservice.demo.dept.dao.DepartmentRepository;
import com.microservice.demo.dept.model.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    @Value("${server.port}")
    private String servicePort;

    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Integer id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Department[%s] not found", id)));
        department.setServicePort(servicePort);
        return department;
    }
}
