package com.example.upstreamapplication.controllers;


import com.example.upstreamapplication.dtos.EmployeeCreateRequestDto;
import com.example.upstreamapplication.models.Employee;
import com.example.upstreamapplication.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") UUID employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeCreateRequestDto employee){
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }


    @DeleteMapping("{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("employeeId") UUID employeeId){
        return ResponseEntity.ok(employeeService.deleteEmployeeById(employeeId));
    }
}
