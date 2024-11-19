package com.vti.finalProject.controller;

import com.vti.finalProject.dto.HREmployeeManagementDTO;
import com.vti.finalProject.form.HREmployeeManagementCreateForm;
import com.vti.finalProject.form.HREmployeeManagementUpdateForm;
import com.vti.finalProject.service.HREmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hr-employees")
public class HREmployeeManagementController {

    @Autowired
    private HREmployeeManagementService service;

    @PostMapping
    public ResponseEntity<HREmployeeManagementDTO> create(@RequestBody HREmployeeManagementCreateForm form) {
        HREmployeeManagementDTO dto = service.create(form);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HREmployeeManagementDTO> update(@PathVariable("id") Long id,
                                                          @RequestBody HREmployeeManagementUpdateForm form) {
        HREmployeeManagementDTO dto = service.update(id, form);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HREmployeeManagementDTO> getById(@PathVariable("id") Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<HREmployeeManagementDTO> getAll() {
        return service.getAll();
    }
}
