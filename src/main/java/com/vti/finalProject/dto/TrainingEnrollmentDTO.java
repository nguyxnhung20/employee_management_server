package com.vti.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TrainingEnrollmentDTO {

    private int enrollmentId;
    private long userId;
    private int trainingId;
    private LocalDate enrollmentDate;
    private String status;
}
