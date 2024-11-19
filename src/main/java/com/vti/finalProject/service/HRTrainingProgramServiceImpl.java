package com.vti.finalProject.service;

import com.vti.finalProject.dto.HRTrainingProgramDTO;
import com.vti.finalProject.entity.HRTrainingProgram;
import com.vti.finalProject.form.HRTrainingProgramCreateForm;
import com.vti.finalProject.form.HRTrainingProgramUpdateForm;
import com.vti.finalProject.mappper.HRTrainingProgramMapper;
import com.vti.finalProject.repository.HRTrainingProgramRepository;
import com.vti.finalProject.service.HRTrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HRTrainingProgramServiceImpl implements HRTrainingProgramService {

    @Autowired
    private HRTrainingProgramRepository repository;

    @Autowired
    private HRTrainingProgramMapper mapper;

    @Override
    public void createTrainingProgram(HRTrainingProgramCreateForm form) {
        HRTrainingProgram entity = mapper.toEntity(form);
        repository.save(entity);
    }

    @Override
    public void updateTrainingProgram(HRTrainingProgramUpdateForm form) {
        HRTrainingProgram entity = mapper.toEntity(form);
        repository.save(entity);
    }

    @Override
    public List<HRTrainingProgramDTO> getAllTrainingPrograms() {
        List<HRTrainingProgram> programs = repository.findAll();
        return programs.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public HRTrainingProgramDTO getTrainingProgramById(int trainingId) {
        HRTrainingProgram entity = repository.findById(trainingId).orElse(null);
        return entity != null ? mapper.toDTO(entity) : null;
    }

    @Override
    public void deleteTrainingProgram(int trainingId) {
        repository.deleteById(trainingId);
    }
}
