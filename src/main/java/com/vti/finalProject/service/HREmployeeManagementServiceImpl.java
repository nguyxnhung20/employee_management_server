package com.vti.finalProject.service;

import com.vti.finalProject.dto.HREmployeeManagementDTO;
import com.vti.finalProject.entity.HREmployeeManagement;
import com.vti.finalProject.form.HREmployeeManagementCreateForm;
import com.vti.finalProject.form.HREmployeeManagementUpdateForm;
import com.vti.finalProject.mappper.HREmployeeManagementMapper;
import com.vti.finalProject.repository.HREmployeeManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HREmployeeManagementServiceImpl implements HREmployeeManagementService {

    @Autowired
    private HREmployeeManagementRepository repository;

    @Autowired
    private HREmployeeManagementMapper mapper;

    @Override
    public HREmployeeManagementDTO create(HREmployeeManagementCreateForm form) {
        HREmployeeManagement entity = mapper.toEntity(form);
        HREmployeeManagement savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public HREmployeeManagementDTO update(Long employeeId, HREmployeeManagementUpdateForm form) {
        if (!repository.existsById(employeeId)) {
            throw new RuntimeException("Employee not found");
        }
        HREmployeeManagement entity = mapper.toEntity(form);
        HREmployeeManagement savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public void delete(Long employeeId) {
        repository.deleteById(employeeId);
    }

    @Override
    public Optional<HREmployeeManagementDTO> getById(Long employeeId) {
        return repository.findById(employeeId).map(mapper::toDTO);
    }

    @Override
    public List<HREmployeeManagementDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
