package com.vti.finalProject.service;


import com.vti.finalProject.dto.WorkScheduleDto;
import com.vti.finalProject.entity.WorkSchedule;
import com.vti.finalProject.form.WorkScheduleCreateForm;
import com.vti.finalProject.form.WorkScheduleUpdateForm;

import java.util.List;

public interface WorkScheduleService {
    WorkScheduleDto createWorkSchedule(WorkScheduleCreateForm form);
    WorkScheduleDto updateWorkSchedule(WorkScheduleUpdateForm form);
    List<WorkScheduleDto> getWorkSchedulesByUserId(Long userId);
    List<WorkScheduleDto> getWorkSchedulesByStatus(WorkSchedule.Status status);
    WorkScheduleDto getWorkScheduleById(Long scheduleId);
    void deleteWorkSchedule(Long scheduleId);
}