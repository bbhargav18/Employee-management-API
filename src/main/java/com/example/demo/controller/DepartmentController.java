package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.request.AddDepartmentRequest;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.impl.DepartmentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody AddDepartmentRequest addDepartmentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(addDepartmentRequest));
    }
}
