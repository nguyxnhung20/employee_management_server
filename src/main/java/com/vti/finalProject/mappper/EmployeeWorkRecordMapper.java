package com.vti.finalProject.mappper;

import com.vti.finalProject.dto.EmployeeWorkRecordDTO;
import com.vti.finalProject.entity.EmployeeWorkRecord;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.form.EmployeeWorkRecordCreateForm;
import com.vti.finalProject.form.EmployeeWorkRecordUpdateForm;

public class EmployeeWorkRecordMapper {

    public static EmployeeWorkRecordDTO toDTO(EmployeeWorkRecord entity) {
        EmployeeWorkRecordDTO dto = new EmployeeWorkRecordDTO();
        dto.setWorkRecordId(entity.getWorkRecordId());
        dto.setUserId(entity.getUser().getId());
        dto.setTaskName(entity.getTaskName());
        dto.setTaskDescription(entity.getTaskDescription());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setDurationInHours(entity.getDurationInHours());
        dto.setStatus(entity.getStatus().name());
        dto.setPerformanceRating(entity.getPerformanceRating().name());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public static EmployeeWorkRecord toEntity(EmployeeWorkRecordCreateForm form) {
        EmployeeWorkRecord entity = new EmployeeWorkRecord();
        entity.setTaskName(form.getTaskName());
        entity.setTaskDescription(form.getTaskDescription());
        entity.setStartTime(form.getStartTime());
        entity.setEndTime(form.getEndTime());
        entity.setDurationInHours(form.getDurationInHours());
        entity.setStatus(EmployeeWorkRecord.Status.valueOf(form.getStatus()));
        entity.setPerformanceRating(EmployeeWorkRecord.PerformanceRating.valueOf(form.getPerformanceRating()));

        User user = new User();
        user.setId(form.getUserId());
        entity.setUser(user);

        return entity;
    }

    public static EmployeeWorkRecord toEntity(EmployeeWorkRecordUpdateForm form, EmployeeWorkRecord existingEntity) {
        existingEntity.setTaskName(form.getTaskName());
        existingEntity.setTaskDescription(form.getTaskDescription());
        existingEntity.setStartTime(form.getStartTime());
        existingEntity.setEndTime(form.getEndTime());
        existingEntity.setDurationInHours(form.getDurationInHours());
        existingEntity.setStatus(EmployeeWorkRecord.Status.valueOf(form.getStatus()));
        existingEntity.setPerformanceRating(EmployeeWorkRecord.PerformanceRating.valueOf(form.getPerformanceRating()));
        return existingEntity;
    }
}
