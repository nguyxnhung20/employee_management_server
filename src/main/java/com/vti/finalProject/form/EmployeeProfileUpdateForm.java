package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeProfileUpdateForm {
    private String jobTitle;
    private String status;
    private LocalDate hireDate;
}
