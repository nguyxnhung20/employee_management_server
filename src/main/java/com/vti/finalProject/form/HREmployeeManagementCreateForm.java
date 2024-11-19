package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HREmployeeManagementCreateForm {
    private long userId;
    private int departmentId;
    private LocalDate hireDate;
    private String evaluation;
}
