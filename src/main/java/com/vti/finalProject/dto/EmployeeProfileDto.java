package com.vti.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeProfileDto {
    private Long profileId;
    private Long userId;
    private String userName;
    private int departmentId;
    private String departmentName;
    private String jobTitle;
    private String status;
    private LocalDate hireDate;
}
