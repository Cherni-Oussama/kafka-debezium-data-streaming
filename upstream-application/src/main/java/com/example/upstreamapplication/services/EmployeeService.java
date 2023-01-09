package com.example.upstreamapplication.services;

import com.example.upstreamapplication.models.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(UUID employeeId);
}
