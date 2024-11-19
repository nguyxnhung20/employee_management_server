package com.vti.finalProject.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class WorkScheduleDto {
    private Long scheduleId;
    private Long userId;
    private LocalDate workDate;
    private Integer workHours;
    private String status;
}