package com.vti.finalProject.service;

import com.vti.finalProject.dto.TrainingEnrollmentDTO;
import com.vti.finalProject.entity.TrainingEnrollment;
import com.vti.finalProject.form.TrainingEnrollmentCreateForm;
import com.vti.finalProject.form.TrainingEnrollmentUpdateForm;
import com.vti.finalProject.mappper.TrainingEnrollmentMapper;
import com.vti.finalProject.repository.TrainingEnrollmentRepository;
import com.vti.finalProject.service.TrainingEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingEnrollmentServiceImpl implements TrainingEnrollmentService {

    @Autowired
    private TrainingEnrollmentRepository repository;

    @Autowired
    private TrainingEnrollmentMapper mapper;

    @Override
    public List<TrainingEnrollmentDTO> getAllTrainingEnrollments() {
        List<TrainingEnrollment> entities = repository.findAll();
        return entities.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public TrainingEnrollmentDTO getTrainingEnrollmentById(int id) {
        TrainingEnrollment entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public void createTrainingEnrollment(TrainingEnrollmentCreateForm form) {
        TrainingEnrollment entity = mapper.toEntity(form);
        repository.save(entity);
    }

    @Override
    public void updateTrainingEnrollment(int id, TrainingEnrollmentUpdateForm form) {
        TrainingEnrollment entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        TrainingEnrollment updatedEntity = mapper.toEntity(form);
        updatedEntity.setEnrollmentId(id);
        repository.save(updatedEntity);
    }

    @Override
    public void deleteTrainingEnrollment(int id) {
        repository.deleteById(id);
    }
}
