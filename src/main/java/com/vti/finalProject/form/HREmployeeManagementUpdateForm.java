package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HREmployeeManagementUpdateForm {

    private Long employeeId;
    private long userId;
    private int departmentId;
    private LocalDate hireDate;
    private String evaluation;
}
