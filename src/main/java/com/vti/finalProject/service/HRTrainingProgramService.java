package com.vti.finalProject.service;

import com.vti.finalProject.dto.HRTrainingProgramDTO;
import com.vti.finalProject.form.HRTrainingProgramCreateForm;
import com.vti.finalProject.form.HRTrainingProgramUpdateForm;

import java.util.List;

public interface HRTrainingProgramService {

    void createTrainingProgram(HRTrainingProgramCreateForm form);

    void updateTrainingProgram(HRTrainingProgramUpdateForm form);

    List<HRTrainingProgramDTO> getAllTrainingPrograms();

    HRTrainingProgramDTO getTrainingProgramById(int trainingId);

    void deleteTrainingProgram(int trainingId);
}
