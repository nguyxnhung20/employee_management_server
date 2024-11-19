package com.vti.finalProject.controller;

import com.vti.finalProject.dto.HRTrainingProgramDTO;
import com.vti.finalProject.form.HRTrainingProgramCreateForm;
import com.vti.finalProject.form.HRTrainingProgramUpdateForm;
import com.vti.finalProject.service.HRTrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-programs")
public class HRTrainingProgramController {

    @Autowired
    private HRTrainingProgramService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrainingProgram(@RequestBody HRTrainingProgramCreateForm form) {
        service.createTrainingProgram(form);
    }

    @PutMapping("/{id}")
    public void updateTrainingProgram(@PathVariable int id, @RequestBody HRTrainingProgramUpdateForm form) {
        form.setTrainingId(id);
        service.updateTrainingProgram(form);
    }

    @GetMapping
    public List<HRTrainingProgramDTO> getAllTrainingPrograms() {
        return service.getAllTrainingPrograms();
    }

    @GetMapping("/{id}")
    public HRTrainingProgramDTO getTrainingProgramById(@PathVariable int id) {
        return service.getTrainingProgramById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainingProgram(@PathVariable int id) {
        service.deleteTrainingProgram(id);
    }
}
