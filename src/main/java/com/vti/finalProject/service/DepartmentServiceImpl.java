package com.vti.finalProject.service;

import com.vti.finalProject.dto.DepartmentDTO;
import com.vti.finalProject.entity.Department;
import com.vti.finalProject.form.DepartmentCreateForm;
import com.vti.finalProject.form.DepartmentUpdateForm;
import com.vti.finalProject.mappper.DepartmentMapper;
import com.vti.finalProject.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Page<DepartmentDTO> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable).map(DepartmentMapper::map);
    }

    @Override
    public DepartmentDTO create(DepartmentCreateForm form) {
        var department = DepartmentMapper.map(form);
        var savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.map(savedDepartment);
    }

    @Override
    public DepartmentDTO update(DepartmentUpdateForm form) {
        Optional<Department> departmentOptional = departmentRepository.findById(form.getDepartmentId());
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setDepartmentName(form.getDepartmentName());
            department.setManagerId(form.getManagerId());
            Department updatedDepartment = departmentRepository.save(department);
            return DepartmentMapper.map(updatedDepartment);
        } else {
            throw new IllegalArgumentException("Department with ID " + form.getDepartmentId() + " not found.");
        }
    }

    @Override
    public void deleteById(int id) {
        departmentRepository.deleteById(id);
    }
}