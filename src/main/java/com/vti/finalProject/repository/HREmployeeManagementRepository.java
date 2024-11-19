package com.vti.finalProject.repository;

import com.vti.finalProject.entity.HREmployeeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HREmployeeManagementRepository extends JpaRepository<HREmployeeManagement, Long> {
}
