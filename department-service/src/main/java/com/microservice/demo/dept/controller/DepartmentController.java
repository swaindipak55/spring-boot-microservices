package com.microservice.demo.dept.controller;

import com.microservice.demo.dept.model.Department;
import com.microservice.demo.dept.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    public final DepartmentService departmentService;

    @GetMapping("department")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("department")
    @ResponseStatus(HttpStatus.CREATED)
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @GetMapping("department/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }
}
