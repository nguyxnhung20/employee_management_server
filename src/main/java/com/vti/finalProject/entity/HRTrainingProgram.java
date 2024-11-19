package com.vti.finalProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "HR_TrainingPrograms")
public class HRTrainingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private int trainingId;

    @Column(name = "training_name", nullable = false)
    private String trainingName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TrainingStatus status;

    public enum TrainingStatus {
        SCHEDULED, ONGOING, COMPLETED
    }
}
