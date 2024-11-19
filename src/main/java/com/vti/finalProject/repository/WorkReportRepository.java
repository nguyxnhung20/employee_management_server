package com.vti.finalProject.repository;

import com.vti.finalProject.entity.WorkReport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkReportRepository extends JpaRepository<WorkReport, Integer> {

    List<WorkReport> findByUserId(Integer userId);

    List<WorkReport> findByStatus(WorkReport.Status status);
}
