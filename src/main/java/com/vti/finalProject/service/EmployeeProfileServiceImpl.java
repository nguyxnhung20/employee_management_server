package com.vti.finalProject.service;

import com.vti.finalProject.dto.EmployeeProfileDto;
import com.vti.finalProject.dto.UserDto;
import com.vti.finalProject.entity.Department;
import com.vti.finalProject.entity.EmployeeProfile;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.form.EmployeeProfileCreateForm;
import com.vti.finalProject.form.EmployeeProfileUpdateForm;
import com.vti.finalProject.mapper.EmployeeProfileMapper;
import com.vti.finalProject.mappper.UserMapper;
import com.vti.finalProject.repository.DepartmentRepository;
import com.vti.finalProject.repository.EmployeeProfileRepository;
import com.vti.finalProject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public List<EmployeeProfileDto> findAll() {
        List<EmployeeProfile> employeeProfiles = profileRepository.findAll();
        return employeeProfiles.stream()
                .map(EmployeeProfileMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeProfileDto create(EmployeeProfileCreateForm form) {
        User user = userRepository.findById(form.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Department department = departmentRepository.findById(form.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));

        EmployeeProfile profile = EmployeeProfileMapper.map(form);
        profile.setUser(user);
        profile.setDepartment(department);
        profile = profileRepository.save(profile);

        return EmployeeProfileMapper.map(profile);
    }

    @Override
    public EmployeeProfileDto update(long id, EmployeeProfileUpdateForm form) {
        EmployeeProfile profile = profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found"));

        if (form.getJobTitle() != null) profile.setJobTitle(form.getJobTitle());
        if (form.getStatus() != null) profile.setStatus(EmployeeProfile.Status.valueOf(form.getStatus()));
        if (form.getHireDate() != null) profile.setHireDate(form.getHireDate());

        profile = profileRepository.save(profile);

        return EmployeeProfileMapper.map(profile);
    }

    @Override
    public void delete(long id) {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Profile not found");
        }
    }

    @Override
    public EmployeeProfileDto getById(long id) {
        EmployeeProfile profile = profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found"));
        return EmployeeProfileMapper.map(profile);
    }
}
