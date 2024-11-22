package com.vti.finalProject.controller;

import com.vti.finalProject.dto.WorkScheduleDto;
import com.vti.finalProject.entity.WorkSchedule;
import com.vti.finalProject.form.WorkScheduleCreateForm;
import com.vti.finalProject.form.WorkScheduleUpdateForm;
import com.vti.finalProject.service.WorkScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/work-schedules")
public class WorkScheduleController {
    @Autowired
    private WorkScheduleService workScheduleService;

    @GetMapping
    public ResponseEntity<List<WorkScheduleDto>> getAllWorkSchedules() {
        return ResponseEntity.ok(workScheduleService.getAllWorkSchedules());
    }

    @PostMapping
    public ResponseEntity<WorkScheduleDto> createWorkSchedule(
            @Valid @RequestBody WorkScheduleCreateForm form) {
        return ResponseEntity.ok(workScheduleService.createWorkSchedule(form));
    }

    @PutMapping
    public ResponseEntity<WorkScheduleDto> updateWorkSchedule(
            @Valid @RequestBody WorkScheduleUpdateForm form) {
        return ResponseEntity.ok(workScheduleService.updateWorkSchedule(form));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkScheduleDto>> getWorkSchedulesByUserId(
            @PathVariable Long userId) {
        return ResponseEntity.ok(workScheduleService.getWorkSchedulesByUserId(userId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<WorkScheduleDto>> getWorkSchedulesByStatus(
            @PathVariable WorkSchedule.Status status) {
        return ResponseEntity.ok(workScheduleService.getWorkSchedulesByStatus(status));
    }
}