package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WorkReportCreateForm {
    private Integer userId;
    private String reportTitle;
    private String reportContent;
    private LocalDate reportDate;
}
