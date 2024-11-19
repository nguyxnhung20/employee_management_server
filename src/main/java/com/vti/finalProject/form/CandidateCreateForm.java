package com.vti.finalProject.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CandidateCreateForm {

    @NotNull
    @Size(min = 1, max = 255)
    private String fullName;

    @NotNull
    @Email
    private String email;

    private String phone;

    private String resumeLink;

    private Date applicationDate;

    private Double interviewScore;

    private String status;
}
