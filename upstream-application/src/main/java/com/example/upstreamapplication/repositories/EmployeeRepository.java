package com.example.upstreamapplication.repositories;

import com.example.upstreamapplication.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
