package com.example.upstreamapplication.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
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

    @OneToMany
    private Set<Employee> employeeSet;
}
