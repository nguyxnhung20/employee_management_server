package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WorkReportUpdateForm {
    private Integer reportId;
    private String reportTitle;
    private String reportContent;
    private LocalDate reportDate;
    private String status;

}
