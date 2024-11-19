package com.vti.finalProject.dto;

import com.vti.finalProject.entity.Candidate;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CandidateDTO {

    private Long candidateId;
    private String fullName;
    private String email;
    private String phone;
    private String resumeLink;
    private Date applicationDate;
    private Double interviewScore;
    private Candidate.CandidateStatus status;

}
