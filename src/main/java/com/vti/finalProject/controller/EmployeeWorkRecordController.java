package com.vti.finalProject.controller;

import com.vti.finalProject.dto.EmployeeWorkRecordDTO;
import com.vti.finalProject.form.EmployeeWorkRecordCreateForm;
import com.vti.finalProject.form.EmployeeWorkRecordUpdateForm;
import com.vti.finalProject.service.EmployeeWorkRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-records")
public class EmployeeWorkRecordController {

    @Autowired
    private EmployeeWorkRecordService service;

    @GetMapping
    public List<EmployeeWorkRecordDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public EmployeeWorkRecordDTO create(@RequestBody EmployeeWorkRecordCreateForm form) {
        return service.create(form);
    }

    @PutMapping("/{id}")
    public EmployeeWorkRecordDTO update(@PathVariable Long id, @RequestBody EmployeeWorkRecordUpdateForm form) {
        return service.update(id, form);
    }

    @GetMapping("/{id}")
    public EmployeeWorkRecordDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
