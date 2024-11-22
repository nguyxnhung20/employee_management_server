package com.vti.finalProject.service;

import com.vti.finalProject.dto.WorkScheduleDto;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.entity.WorkSchedule;
import com.vti.finalProject.form.WorkScheduleCreateForm;
import com.vti.finalProject.form.WorkScheduleUpdateForm;
import com.vti.finalProject.mappper.WorkScheduleMapper;
import com.vti.finalProject.repository.UserRepository;
import com.vti.finalProject.repository.WorkScheduleRepository;
import com.vti.finalProject.service.WorkScheduleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkScheduleServiceImpl implements WorkScheduleService {

    @Autowired
    private WorkScheduleRepository workScheduleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkScheduleMapper workScheduleMapper;

    @Override
    @Transactional(readOnly = true)
    public List<WorkScheduleDto> getAllWorkSchedules() {
        return workScheduleRepository.findAll()
                .stream()
                .map(workScheduleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public WorkScheduleDto createWorkSchedule(WorkScheduleCreateForm form) {
        User user = userRepository.findById(form.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + form.getUserId()));

        WorkSchedule workSchedule = workScheduleMapper.toEntity(form);
        workSchedule.setUser(user);

        WorkSchedule savedSchedule = workScheduleRepository.save(workSchedule);
        return workScheduleMapper.toDto(savedSchedule);
    }

    @Override
    @Transactional
    public WorkScheduleDto updateWorkSchedule(WorkScheduleUpdateForm form) {
        WorkSchedule existingSchedule = workScheduleRepository.findById(form.getScheduleId())
                .orElseThrow(() -> new EntityNotFoundException("Work Schedule not found"));

        workScheduleMapper.updateEntityFromForm(form, existingSchedule);
        WorkSchedule updatedSchedule = workScheduleRepository.save(existingSchedule);
        return workScheduleMapper.toDto(updatedSchedule);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkScheduleDto> getWorkSchedulesByUserId(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        return workScheduleRepository.findByUser_Id(userId)
                .stream()
                .map(workScheduleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkScheduleDto> getWorkSchedulesByStatus(WorkSchedule.Status status) {
        return workScheduleRepository.findByStatus(status)
                .stream()
                .map(workScheduleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public WorkScheduleDto getWorkScheduleById(Long scheduleId) {
        WorkSchedule workSchedule = workScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new EntityNotFoundException("Work Schedule not found"));

        return workScheduleMapper.toDto(workSchedule);
    }

    @Override
    @Transactional
    public void deleteWorkSchedule(Long scheduleId) {
        WorkSchedule workSchedule = workScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new EntityNotFoundException("Work Schedule not found"));

        workScheduleRepository.delete(workSchedule);
    }
}