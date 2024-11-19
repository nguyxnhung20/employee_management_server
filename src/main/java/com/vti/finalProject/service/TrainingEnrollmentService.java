package com.vti.finalProject.service;

import com.vti.finalProject.dto.TrainingEnrollmentDTO;
import com.vti.finalProject.form.TrainingEnrollmentCreateForm;
import com.vti.finalProject.form.TrainingEnrollmentUpdateForm;

import java.util.List;

public interface TrainingEnrollmentService {

    List<TrainingEnrollmentDTO> getAllTrainingEnrollments();

    TrainingEnrollmentDTO getTrainingEnrollmentById(int id);

    void createTrainingEnrollment(TrainingEnrollmentCreateForm form);

    void updateTrainingEnrollment(int id, TrainingEnrollmentUpdateForm form);

    void deleteTrainingEnrollment(int id);
}
