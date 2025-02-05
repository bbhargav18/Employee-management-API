package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.request.AddDepartmentRequest;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();

    Department addDepartment(AddDepartmentRequest addDepartmentRequest);
}
