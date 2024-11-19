package com.vti.finalProject.service;

import com.vti.finalProject.dto.EmployeeWorkRecordDTO;
import com.vti.finalProject.form.EmployeeWorkRecordCreateForm;
import com.vti.finalProject.form.EmployeeWorkRecordUpdateForm;

import java.util.List;

public interface EmployeeWorkRecordService {

    List<EmployeeWorkRecordDTO> getAll();

    EmployeeWorkRecordDTO create(EmployeeWorkRecordCreateForm form);

    EmployeeWorkRecordDTO update(Long id, EmployeeWorkRecordUpdateForm form);

    EmployeeWorkRecordDTO getById(Long id);
}
