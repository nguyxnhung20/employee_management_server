package com.vti.finalProject.controller;

import com.vti.finalProject.dto.DepartmentDTO;
import com.vti.finalProject.form.DepartmentCreateForm;
import com.vti.finalProject.form.DepartmentUpdateForm;
import com.vti.finalProject.service.DepartmentService;
import com.vti.finalProject.validation.DepartmentPkExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/api/v1/departments")
    public Page<DepartmentDTO> findAll(Pageable pageable) {
        return departmentService.findAll(pageable);
    }

    @PostMapping("/api/v1/departments")
    public DepartmentDTO create(@RequestBody @Valid DepartmentCreateForm form) {
        return departmentService.create(form);
    }

    @PutMapping("/api/v1/departments")
    public DepartmentDTO update(@RequestBody @Valid DepartmentUpdateForm form) {
        return departmentService.update(form);
    }

    @DeleteMapping("/api/v1/departments/{id}")
    public void deleteById(@PathVariable @DepartmentPkExists Integer id) {
        departmentService.deleteById(id);
    }
}
