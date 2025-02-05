package com.example.demo.service.impl;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.request.AddDepartmentRequest;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Department addDepartment(AddDepartmentRequest addDepartmentRequest) {
        Department department = new Department();
        BeanUtils.copyProperties(addDepartmentRequest, department);
        return departmentRepository.save(department);
    }
}
