package com.vti.finalProject.controller;

import com.vti.finalProject.dto.EmployeeProfileDto;
import com.vti.finalProject.form.EmployeeProfileCreateForm;
import com.vti.finalProject.form.EmployeeProfileUpdateForm;
import com.vti.finalProject.service.EmployeeProfileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/employee-profiles")
public class EmployeeProfileController {

    private final EmployeeProfileService profileService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeProfileDto create(@RequestBody @Valid EmployeeProfileCreateForm form) {
        return profileService.create(form);
    }

    @GetMapping("/{id}")
    public EmployeeProfileDto getById(@PathVariable long id) {
        return profileService.getById(id);
    }

    @PutMapping("/{id}")
    public EmployeeProfileDto update(@PathVariable long id, @RequestBody @Valid EmployeeProfileUpdateForm form) {
        return profileService.update(id, form);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        profileService.delete(id);
    }

    @GetMapping
    public List<EmployeeProfileDto> findAll() {
        return profileService.findAll();
    }
}
