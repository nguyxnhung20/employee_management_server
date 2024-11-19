package com.vti.finalProject.mappper;


import com.vti.finalProject.dto.WorkScheduleDto;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.entity.WorkSchedule;
import com.vti.finalProject.form.WorkScheduleCreateForm;
import com.vti.finalProject.form.WorkScheduleUpdateForm;
import org.springframework.stereotype.Component;

@Component
public class WorkScheduleMapper {
    public WorkScheduleDto toDto(WorkSchedule workSchedule) {
        if (workSchedule == null) return null;

        WorkScheduleDto dto = new WorkScheduleDto();
        dto.setScheduleId(workSchedule.getScheduleId());
        dto.setUserId(workSchedule.getUser() != null ? workSchedule.getUser().getId() : null);
        dto.setWorkDate(workSchedule.getWorkDate());
        dto.setWorkHours(workSchedule.getWorkHours());
        dto.setStatus(workSchedule.getStatus() != null ? workSchedule.getStatus().name() : null);
        return dto;
    }

    public WorkSchedule toEntity(WorkScheduleCreateForm form) {
        if (form == null) return null;

        WorkSchedule workSchedule = new WorkSchedule();
        User user = new User();
        user.setId(form.getUserId());

        workSchedule.setUser(user);
        workSchedule.setWorkDate(form.getWorkDate());
        workSchedule.setWorkHours(form.getWorkHours());
        workSchedule.setStatus(WorkSchedule.Status.PENDING);
        return workSchedule;
    }

    public void updateEntityFromForm(WorkScheduleUpdateForm form, WorkSchedule workSchedule) {
        if (form == null || workSchedule == null) return;

        if (form.getWorkDate() != null) {
            workSchedule.setWorkDate(form.getWorkDate());
        }

        if (form.getWorkHours() != null) {
            workSchedule.setWorkHours(form.getWorkHours());
        }

        if (form.getStatus() != null) {
            workSchedule.setStatus(WorkSchedule.Status.valueOf(form.getStatus()));
        }
    }
}