package com.vti.finalProject.service;

import com.vti.finalProject.dto.EmployeeWorkRecordDTO;
import com.vti.finalProject.entity.EmployeeWorkRecord;
import com.vti.finalProject.form.EmployeeWorkRecordCreateForm;
import com.vti.finalProject.form.EmployeeWorkRecordUpdateForm;
import com.vti.finalProject.mappper.EmployeeWorkRecordMapper;
import com.vti.finalProject.repository.EmployeeWorkRecordRepository;
import com.vti.finalProject.service.EmployeeWorkRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeWorkRecordServiceImpl implements EmployeeWorkRecordService {

    @Autowired
    private EmployeeWorkRecordRepository repository;

    @Override
    public List<EmployeeWorkRecordDTO> getAll() {
        List<EmployeeWorkRecord> records = repository.findAll();
        return records.stream()
                .map(EmployeeWorkRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeWorkRecordDTO create(EmployeeWorkRecordCreateForm form) {
        EmployeeWorkRecord entity = EmployeeWorkRecordMapper.toEntity(form);
        EmployeeWorkRecord savedEntity = repository.save(entity);
        return EmployeeWorkRecordMapper.toDTO(savedEntity);
    }

    @Override
    public EmployeeWorkRecordDTO update(Long id, EmployeeWorkRecordUpdateForm form) {
        EmployeeWorkRecord existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Work record not found"));
        EmployeeWorkRecord updatedEntity = EmployeeWorkRecordMapper.toEntity(form, existingEntity);
        updatedEntity = repository.save(updatedEntity);
        return EmployeeWorkRecordMapper.toDTO(updatedEntity);
    }

    @Override
    public EmployeeWorkRecordDTO getById(Long id) {
        EmployeeWorkRecord entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Work record not found"));
        return EmployeeWorkRecordMapper.toDTO(entity);
    }
}
