package com.vti.finalProject.mappper;

import com.vti.finalProject.dto.TrainingEnrollmentDTO;
import com.vti.finalProject.entity.EnrollmentStatus;
import com.vti.finalProject.entity.TrainingEnrollment;
import com.vti.finalProject.form.TrainingEnrollmentCreateForm;
import com.vti.finalProject.form.TrainingEnrollmentUpdateForm;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.entity.HRTrainingProgram;
import org.springframework.stereotype.Component;

@Component
public class TrainingEnrollmentMapper {

    public TrainingEnrollmentDTO toDTO(TrainingEnrollment entity) {
        TrainingEnrollmentDTO dto = new TrainingEnrollmentDTO();
        dto.setEnrollmentId(entity.getEnrollmentId());
        dto.setUserId(entity.getUser().getId());
        dto.setTrainingId(entity.getTraining().getTrainingId());
        dto.setEnrollmentDate(entity.getEnrollmentDate());
        dto.setStatus(entity.getStatus().name());
        return dto;
    }

    public TrainingEnrollment toEntity(TrainingEnrollmentCreateForm form) {
        TrainingEnrollment entity = new TrainingEnrollment();
        User user = new User();
        user.setId(form.getUserId());
        entity.setUser(user);

        HRTrainingProgram training = new HRTrainingProgram();
        training.setTrainingId(form.getTrainingId());
        entity.setTraining(training);

        entity.setEnrollmentDate(form.getEnrollmentDate());
        entity.setStatus(EnrollmentStatus.valueOf(form.getStatus()));
        return entity;
    }

    public TrainingEnrollment toEntity(TrainingEnrollmentUpdateForm form) {
        TrainingEnrollment entity = new TrainingEnrollment();
        entity.setEnrollmentId(form.getEnrollmentId());

        User user = new User();
        user.setId(form.getUserId());
        entity.setUser(user);

        HRTrainingProgram training = new HRTrainingProgram();
        training.setTrainingId(form.getTrainingId());
        entity.setTraining(training);

        entity.setStatus(EnrollmentStatus.valueOf(form.getStatus()));
        return entity;
    }
}
