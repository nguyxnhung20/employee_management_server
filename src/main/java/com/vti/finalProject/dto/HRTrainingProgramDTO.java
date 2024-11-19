package com.vti.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class HRTrainingProgramDTO {

    private int trainingId;
    private String trainingName;
    private String description;
    private Date startDate;
    private Date endDate;
    private String status;
}
