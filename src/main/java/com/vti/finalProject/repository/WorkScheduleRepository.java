package com.vti.finalProject.repository;


import com.vti.finalProject.entity.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
    List<WorkSchedule> findByUser_Id(Long Id);
    List<WorkSchedule> findByStatus(WorkSchedule.Status status);
}