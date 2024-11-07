package com.vti.finalProject.mappper;

import com.vti.finalProject.dto.DepartmentDTO;
import com.vti.finalProject.entity.Department;
import com.vti.finalProject.form.DepartmentCreateForm;
import com.vti.finalProject.form.DepartmentUpdateForm;

public class DepartmentMapper {

    public static Department map(DepartmentCreateForm form) {
        var department = new Department();

        department.setDepartmentName(form.getDepartmentName());
        department.setManagerId(form.getManagerId());

        return department;
    }

    public static DepartmentDTO map(Department department) {
        var dto = new DepartmentDTO();

        dto.setDepartmentId(department.getDepartmentId());
        dto.setDepartmentName(department.getDepartmentName());
        dto.setManagerId(department.getManagerId());

        return dto;
    }

    public static void map(DepartmentUpdateForm form, Department department) {
        department.setDepartmentName(form.getDepartmentName());
        department.setManagerId(form.getManagerId());
    }
}
