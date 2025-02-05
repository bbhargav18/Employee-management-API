package com.example.demo.request;

import lombok.Data;

@Data
public class AddEmployeeRequest {
    private String id;
    private String name;
    private String email;
    private String position;
    private double salary;
    private String departmentId;
}
