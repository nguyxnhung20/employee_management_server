package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TrainingEnrollmentUpdateForm {

    private int enrollmentId;
    private long userId;
    private int trainingId;
    private String status;
    private LocalDate enrollmentDate;
}
