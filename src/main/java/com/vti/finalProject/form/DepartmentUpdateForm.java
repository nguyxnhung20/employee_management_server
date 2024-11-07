package com.vti.finalProject.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class DepartmentUpdateForm {
    @NotNull(message = "{department.departmentId.NotNull.message}")
    private int departmentId;

    @NotBlank(message = "{department.departmentName.NotBlank.message}")
    @Length(max = 255, message = "{department.departmentName.Length.message}")
    private String departmentName;

    @NotNull(message = "{department.managerId.NotNull.message}")
    private int managerId;
}