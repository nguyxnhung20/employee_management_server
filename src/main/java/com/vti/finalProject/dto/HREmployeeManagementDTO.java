package com.vti.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HREmployeeManagementDTO {

    private Long employeeId;
    private long userId;
    private int departmentId;
    private LocalDate hireDate;
    private String evaluation;
}
