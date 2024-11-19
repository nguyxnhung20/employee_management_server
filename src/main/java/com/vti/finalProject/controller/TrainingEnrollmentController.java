package com.vti.finalProject.controller;

import com.vti.finalProject.dto.TrainingEnrollmentDTO;
import com.vti.finalProject.form.TrainingEnrollmentCreateForm;
import com.vti.finalProject.form.TrainingEnrollmentUpdateForm;
import com.vti.finalProject.service.TrainingEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-enrollments")
public class TrainingEnrollmentController {

    @Autowired
    private TrainingEnrollmentService service;

    @GetMapping
    public List<TrainingEnrollmentDTO> getAllTrainingEnrollments() {
        return service.getAllTrainingEnrollments();
    }

    @GetMapping("/{id}")
    public TrainingEnrollmentDTO getTrainingEnrollmentById(@PathVariable int id) {
        return service.getTrainingEnrollmentById(id);
    }

    @PostMapping
    public void createTrainingEnrollment(@RequestBody TrainingEnrollmentCreateForm form) {
        service.createTrainingEnrollment(form);
    }

    @PutMapping("/{id}")
    public void updateTrainingEnrollment(@PathVariable int id, @RequestBody TrainingEnrollmentUpdateForm form) {
        service.updateTrainingEnrollment(id, form);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainingEnrollment(@PathVariable int id) {
        service.deleteTrainingEnrollment(id);
    }
}
