package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EmployeeWorkRecordUpdateForm {

    private String taskName;
    private String taskDescription;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double durationInHours;
    private String status;
    private String performanceRating;
}
