package com.vti.finalProject.repository;

import com.vti.finalProject.entity.HRTrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRTrainingProgramRepository extends JpaRepository<HRTrainingProgram, Integer> {
}
