package com.vti.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EmployeeWorkRecordDTO {
    private Long workRecordId;
    private Long userId;
    private String taskName;
    private String taskDescription;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double durationInHours;
    private String status;
    private String performanceRating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
