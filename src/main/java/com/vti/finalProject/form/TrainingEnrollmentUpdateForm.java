package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainingEnrollmentUpdateForm {

    private int enrollmentId;
    private long userId;
    private int trainingId;
    private String status;
}
