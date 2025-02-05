package com.example.demo.service.impl;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.request.AddEmployeeRequest;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.AppConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository   employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeDetails(String id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Employee addUpdateEmployee(AddEmployeeRequest addEmployeeRequest) {
        Department department = departmentRepository.findById(addEmployeeRequest.getDepartmentId()).get();
        Employee   employee   = new Employee();
        BeanUtils.copyProperties(addEmployeeRequest, employee);
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
        return Map.of(AppConstants.MESSAGE, AppConstants.EMPLOYEE_DELETE_MESSAGE);
    }
}
