package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class HRTrainingProgramCreateForm {

    private String trainingName;
    private String description;
    private Date startDate;
    private Date endDate;
    private String status;
}
