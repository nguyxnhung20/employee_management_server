package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TrainingEnrollmentCreateForm {

    private long userId;
    private int trainingId;
    private LocalDate enrollmentDate;
    private String status;
}
