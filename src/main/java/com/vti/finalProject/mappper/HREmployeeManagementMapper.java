package com.vti.finalProject.mappper;

import com.vti.finalProject.dto.HREmployeeManagementDTO;
import com.vti.finalProject.entity.Department;
import com.vti.finalProject.entity.HREmployeeManagement;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.form.HREmployeeManagementCreateForm;
import com.vti.finalProject.form.HREmployeeManagementUpdateForm;
import org.springframework.stereotype.Component;

@Component
public class HREmployeeManagementMapper {

    public HREmployeeManagementDTO toDTO(HREmployeeManagement entity) {
        HREmployeeManagementDTO dto = new HREmployeeManagementDTO();
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setUserId(entity.getUser().getId());
        dto.setDepartmentId(entity.getDepartment().getDepartmentId());
        dto.setHireDate(entity.getHireDate());
        dto.setEvaluation(entity.getEvaluation());
        return dto;
    }

    public HREmployeeManagement toEntity(HREmployeeManagementCreateForm form) {
        HREmployeeManagement entity = new HREmployeeManagement();
        User user = new User();
        user.setId(form.getUserId());
        entity.setUser(user);

        Department department = new Department();
        department.setDepartmentId(form.getDepartmentId());
        entity.setDepartment(department);

        entity.setHireDate(form.getHireDate());
        entity.setEvaluation(form.getEvaluation());
        return entity;
    }

    public HREmployeeManagement toEntity(HREmployeeManagementUpdateForm form) {
        HREmployeeManagement entity = new HREmployeeManagement();
        entity.setEmployeeId(form.getEmployeeId());

        User user = new User();
        user.setId(form.getUserId());
        entity.setUser(user);

        Department department = new Department();
        department.setDepartmentId(form.getDepartmentId());
        entity.setDepartment(department);

        entity.setHireDate(form.getHireDate());
        entity.setEvaluation(form.getEvaluation());
        return entity;
    }
}
