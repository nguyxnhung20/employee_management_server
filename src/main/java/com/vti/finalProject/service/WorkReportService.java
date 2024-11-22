package com.vti.finalProject.service;

import com.vti.finalProject.dto.WorkReportDTO;
import com.vti.finalProject.entity.WorkReport;
import com.vti.finalProject.form.WorkReportCreateForm;
import com.vti.finalProject.form.WorkReportUpdateForm;

import java.util.List;

public interface WorkReportService {

    List<WorkReport> findAll();

    WorkReportDTO createWorkReport(WorkReportCreateForm form);

    WorkReportDTO updateWorkReport(WorkReportUpdateForm form);

    List<WorkReportDTO> getReportsByUserId(Integer userId);

    List<WorkReportDTO> getReportsByStatus(WorkReport.Status status);
}
