package com.vti.finalProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String requestType;
    private String requestDetail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    private boolean approvedByManager;
    private boolean approvedByAdmin;


    public enum Status {
        PENDING,
        MANAGER_APPROVED,
        ADMIN_APPROVED,
        REJECTED
    }
}
