package com.example.upstreamapplication.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Document(collation = "CompanyCollection")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    private UUID companyId;

    private String companyName;

    private LocalDateTime createdAt;

    private LocalDateTime registeredAt;

    private Integer employeesNumber;

    private String sector;

    private Set<Employee> employeeSet;
}
