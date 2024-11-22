package com.vti.finalProject.service;

import com.vti.finalProject.dto.WorkReportDTO;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.entity.WorkReport;
import com.vti.finalProject.form.WorkReportCreateForm;
import com.vti.finalProject.form.WorkReportUpdateForm;
import com.vti.finalProject.mappper.WorkReportMapper;
import com.vti.finalProject.repository.UserRepository;
import com.vti.finalProject.repository.WorkReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkReportServiceImpl implements WorkReportService {

    @Autowired
    private WorkReportRepository workReportRepository;

    @Autowired
    private WorkReportMapper workReportMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<WorkReport> findAll() {
        return workReportRepository.findAll();
    }

    @Transactional
    @Override
    public WorkReportDTO createWorkReport(WorkReportCreateForm form) {
        Optional<User> user = Optional.ofNullable(userRepository.findById(form.getUserId()));
        if (!user.isPresent()) {
            throw new RuntimeException("User not found");
        }

        WorkReport workReport = workReportMapper.createFormToEntity(form, user.get());
        workReport = workReportRepository.save(workReport);

        return workReportMapper.entityToDto(workReport);
    }

    @Transactional
    @Override
    public WorkReportDTO updateWorkReport(WorkReportUpdateForm form) {
        Optional<WorkReport> existingReport = workReportRepository.findById(form.getReportId());
        if (existingReport.isPresent()) {
            WorkReport workReport = existingReport.get();
            workReport = workReportMapper.updateFormToEntity(form, workReport);
            workReport = workReportRepository.save(workReport);
            return workReportMapper.entityToDto(workReport);
        } else {
            throw new RuntimeException("WorkReport not found");
        }
    }

    @Override
    public List<WorkReportDTO> getReportsByUserId(Integer userId) {
        List<WorkReport> workReports = workReportRepository.findByUserId(userId);
        return workReports.stream()
                .map(workReportMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkReportDTO> getReportsByStatus(WorkReport.Status status) {
        List<WorkReport> workReports = workReportRepository.findByStatus(status);
        return workReports.stream()
                .map(workReportMapper::entityToDto)
                .collect(Collectors.toList());
    }
}