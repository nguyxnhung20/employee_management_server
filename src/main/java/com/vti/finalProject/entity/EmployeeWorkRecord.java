package com.vti.finalProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "EmployeeWorkRecords")
public class EmployeeWorkRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_record_id")
    private Long workRecordId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "duration_in_hours")
    private Double durationInHours;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.NOT_STARTED;

    @Enumerated(EnumType.STRING)
    @Column(name = "performance_rating")
    private PerformanceRating performanceRating = PerformanceRating.AVERAGE;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum Status {
        NOT_STARTED, IN_PROGRESS, COMPLETED, OVERDUE
    }

    public enum PerformanceRating {
        POOR, AVERAGE, GOOD, EXCELLENT
    }
}
