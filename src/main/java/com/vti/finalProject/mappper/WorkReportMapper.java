package com.vti.finalProject.mappper;

import com.vti.finalProject.dto.WorkReportDTO;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.entity.WorkReport;
import com.vti.finalProject.form.WorkReportCreateForm;
import com.vti.finalProject.form.WorkReportUpdateForm;
import org.springframework.stereotype.Component;

@Component
public class WorkReportMapper {

    public WorkReportDTO entityToDto(WorkReport workReport) {
        if (workReport == null) {
            return null;
        }
        WorkReportDTO dto = new WorkReportDTO();
        dto.setReportId(workReport.getReportId());
        dto.setUserId(Math.toIntExact(workReport.getUser() != null ? workReport.getUser().getId() : null));
        dto.setReportTitle(workReport.getReportTitle());
        dto.setReportContent(workReport.getReportContent());
        dto.setReportDate(workReport.getReportDate());
        dto.setStatus(workReport.getStatus().toString());
        return dto;
    }

    public WorkReport dtoToEntity(WorkReportDTO dto) {
        if (dto == null) {
            return null;
        }
        WorkReport workReport = new WorkReport();
        workReport.setReportId(dto.getReportId());
        workReport.setReportTitle(dto.getReportTitle());
        workReport.setReportContent(dto.getReportContent());
        workReport.setReportDate(dto.getReportDate());
        workReport.setStatus(WorkReport.Status.valueOf(dto.getStatus().toUpperCase()));
        return workReport;
    }

    public WorkReport createFormToEntity(WorkReportCreateForm form, User user) {
        if (form == null || user == null) {
            return null;
        }
        WorkReport workReport = new WorkReport();
        workReport.setUser(user);
        workReport.setReportTitle(form.getReportTitle());
        workReport.setReportContent(form.getReportContent());
        workReport.setReportDate(form.getReportDate());
        workReport.setStatus(WorkReport.Status.PENDING);
        return workReport;
    }

    public WorkReport updateFormToEntity(WorkReportUpdateForm form, WorkReport workReport) {
        if (form == null || workReport == null) {
            return null;
        }
        workReport.setReportTitle(form.getReportTitle());
        workReport.setReportContent(form.getReportContent());
        workReport.setReportDate(form.getReportDate());
        workReport.setStatus(WorkReport.Status.valueOf(form.getStatus().toUpperCase()));
        return workReport;
    }
}
