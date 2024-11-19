package com.vti.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WorkReportDTO {
    private Integer reportId;
    private Integer userId;
    private String reportTitle;
    private String reportContent;
    private LocalDate reportDate;
    private String status;
}
