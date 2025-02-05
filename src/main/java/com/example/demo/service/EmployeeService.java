package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.request.AddEmployeeRequest;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeDetails(String id);

    List<Employee> getEmployeesByDepartment(String deptId);

    Employee addUpdateEmployee(AddEmployeeRequest addEmployeeRequest);

    Map<String, String> deleteEmployee(String id);
}
