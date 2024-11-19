package com.vti.finalProject.service;

import com.vti.finalProject.dto.EmployeeProfileDto;
import com.vti.finalProject.form.EmployeeProfileCreateForm;
import com.vti.finalProject.form.EmployeeProfileUpdateForm;

public interface EmployeeProfileService {
    EmployeeProfileDto create(EmployeeProfileCreateForm form);
    EmployeeProfileDto update(long id, EmployeeProfileUpdateForm form);
    void delete(long id);
    EmployeeProfileDto getById(long id);
}
