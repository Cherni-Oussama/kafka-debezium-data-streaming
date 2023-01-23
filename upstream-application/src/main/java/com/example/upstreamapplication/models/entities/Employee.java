package com.example.upstreamapplication.models.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collation = "EmployeeCollection")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    private UUID employeeId;

    private String employeeFirstName;

    private String employeeLastName;

    private Integer age;

    private String positionTitle;
}
