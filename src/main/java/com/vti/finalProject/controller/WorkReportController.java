package com.vti.finalProject.controller;

import com.vti.finalProject.dto.WorkReportDTO;
import com.vti.finalProject.entity.WorkReport;
import com.vti.finalProject.form.WorkReportCreateForm;
import com.vti.finalProject.form.WorkReportUpdateForm;
import com.vti.finalProject.service.WorkReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workreports")
public class WorkReportController {

    @Autowired
    private WorkReportService workReportService;

    @PostMapping("/create")
    public WorkReportDTO createWorkReport(@RequestBody WorkReportCreateForm form) {
        return workReportService.createWorkReport(form);
    }

    @PutMapping("/update")
    public WorkReportDTO updateWorkReport(@RequestBody WorkReportUpdateForm form) {
        return workReportService.updateWorkReport(form);
    }

    @GetMapping("/user/{userId}")
    public List<WorkReportDTO> getReportsByUserId(@PathVariable Integer userId) {
        return workReportService.getReportsByUserId(userId);
    }

    @GetMapping("/status/{status}")
    public List<WorkReportDTO> getReportsByStatus(@PathVariable String status) {
        return workReportService.getReportsByStatus(WorkReport.Status.valueOf(status.toUpperCase()));
    }
}
