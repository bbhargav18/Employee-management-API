package com.example.demo.request;

import lombok.Data;

@Data
public class AddDepartmentRequest {
    private String id;
    private String name;
    private String location;
}
