package com.example.upstreamapplication.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeCreateRequestDto implements Serializable {

    private String employeeFirstName;

    private String employeeLastName;

    private Integer age;

    private String positionTitle;

}
