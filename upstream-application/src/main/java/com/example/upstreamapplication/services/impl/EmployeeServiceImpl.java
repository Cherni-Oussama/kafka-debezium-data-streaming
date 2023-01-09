package com.example.upstreamapplication.services.impl;

import com.example.upstreamapplication.models.Employee;
import com.example.upstreamapplication.repositories.EmployeeRepository;
import com.example.upstreamapplication.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
