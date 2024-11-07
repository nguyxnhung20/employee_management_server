package com.vti.finalProject.service;

import com.vti.finalProject.dto.DepartmentDTO;
import com.vti.finalProject.form.DepartmentCreateForm;
import com.vti.finalProject.form.DepartmentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {
    Page<DepartmentDTO> findAll(Pageable pageable);
    DepartmentDTO create(DepartmentCreateForm form);
    DepartmentDTO update(DepartmentUpdateForm form);
    void deleteById(int id);
}
