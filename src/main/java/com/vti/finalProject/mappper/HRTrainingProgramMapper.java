package com.vti.finalProject.mappper;

import com.vti.finalProject.dto.HRTrainingProgramDTO;
import com.vti.finalProject.entity.HRTrainingProgram;
import com.vti.finalProject.form.HRTrainingProgramCreateForm;
import com.vti.finalProject.form.HRTrainingProgramUpdateForm;
import org.springframework.stereotype.Component;

@Component
public class HRTrainingProgramMapper {

    public HRTrainingProgramDTO toDTO(HRTrainingProgram entity) {
        HRTrainingProgramDTO dto = new HRTrainingProgramDTO();
        dto.setTrainingId(entity.getTrainingId());
        dto.setTrainingName(entity.getTrainingName());
        dto.setDescription(entity.getDescription());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setStatus(entity.getStatus().name());
        return dto;
    }

    public HRTrainingProgram toEntity(HRTrainingProgramCreateForm form) {
        HRTrainingProgram entity = new HRTrainingProgram();
        entity.setTrainingName(form.getTrainingName());
        entity.setDescription(form.getDescription());
        entity.setStartDate(form.getStartDate());
        entity.setEndDate(form.getEndDate());
        entity.setStatus(HRTrainingProgram.TrainingStatus.valueOf(form.getStatus()));
        return entity;
    }

    public HRTrainingProgram toEntity(HRTrainingProgramUpdateForm form) {
        HRTrainingProgram entity = new HRTrainingProgram();
        entity.setTrainingId(form.getTrainingId());
        entity.setTrainingName(form.getTrainingName());
        entity.setDescription(form.getDescription());
        entity.setStartDate(form.getStartDate());
        entity.setEndDate(form.getEndDate());
        entity.setStatus(HRTrainingProgram.TrainingStatus.valueOf(form.getStatus()));
        return entity;
    }
}
