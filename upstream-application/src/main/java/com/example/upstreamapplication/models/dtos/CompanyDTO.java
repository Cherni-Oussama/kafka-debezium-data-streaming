package com.example.upstreamapplication.models.dtos;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CompanyDTO {

    private String companyName;

    private LocalDateTime createdAt;

    private LocalDateTime registeredAt;

    private Integer employeesNumber;

    private String sector;

}
