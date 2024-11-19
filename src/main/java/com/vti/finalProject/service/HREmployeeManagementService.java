package com.vti.finalProject.service;

import com.vti.finalProject.dto.HREmployeeManagementDTO;
import com.vti.finalProject.form.HREmployeeManagementCreateForm;
import com.vti.finalProject.form.HREmployeeManagementUpdateForm;

import java.util.List;
import java.util.Optional;

public interface HREmployeeManagementService {

    HREmployeeManagementDTO create(HREmployeeManagementCreateForm form);

    HREmployeeManagementDTO update(Long employeeId, HREmployeeManagementUpdateForm form);

    void delete(Long employeeId);

    Optional<HREmployeeManagementDTO> getById(Long employeeId);

    List<HREmployeeManagementDTO> getAll();
}
