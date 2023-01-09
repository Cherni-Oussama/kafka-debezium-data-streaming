package com.example.upstreamapplication.services.impl;

import com.example.upstreamapplication.dtos.EmployeeCreateRequestDto;
import com.example.upstreamapplication.exceptions.ItemNotFoundException;
import com.example.upstreamapplication.models.Employee;
import com.example.upstreamapplication.repositories.EmployeeRepository;
import com.example.upstreamapplication.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ItemNotFoundException("Employee Not Found", null, null, HttpStatus.NOT_FOUND));
    }

    @Override
    public Employee createEmployee(EmployeeCreateRequestDto employee) {
        return employeeRepository.save(Employee.builder()
                        .employeeId(UUID.randomUUID())
                        .employeeFirstName(employee.getEmployeeFirstName())
                        .employeeLastName(employee.getEmployeeLastName())
                        .age(employee.getAge())
                        .positionTitle(employee.getPositionTitle())
                        .build());
    }
}
