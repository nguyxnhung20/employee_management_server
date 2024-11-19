package com.vti.finalProject.mappper;

import com.vti.finalProject.dto.CandidateDTO;
import com.vti.finalProject.entity.Candidate;
import com.vti.finalProject.form.CandidateCreateForm;
import com.vti.finalProject.form.CandidateUpdateForm;

import java.util.Date;

public class CandidateMapper {

    public static Candidate toEntity(CandidateCreateForm form) {
        Candidate candidate = new Candidate();
        candidate.setFullName(form.getFullName());
        candidate.setEmail(form.getEmail());
        candidate.setPhone(form.getPhone());
        candidate.setResumeLink(form.getResumeLink());
        candidate.setApplicationDate(form.getApplicationDate() == null ? new Date() : form.getApplicationDate());
        candidate.setInterviewScore(form.getInterviewScore());
        candidate.setStatus(Candidate.CandidateStatus.valueOf(form.getStatus()));
        return candidate;
    }

    public static CandidateDTO toDTO(Candidate candidate) {
        CandidateDTO dto = new CandidateDTO();
        dto.setCandidateId(candidate.getCandidateId());
        dto.setFullName(candidate.getFullName());
        dto.setEmail(candidate.getEmail());
        dto.setPhone(candidate.getPhone());
        dto.setResumeLink(candidate.getResumeLink());
        dto.setApplicationDate(candidate.getApplicationDate());
        dto.setInterviewScore(candidate.getInterviewScore());
        dto.setStatus(candidate.getStatus());
        return dto;
    }

    public static Candidate toEntity(CandidateUpdateForm form, Candidate existingCandidate) {
        if (form.getPhone() != null) {
            existingCandidate.setPhone(form.getPhone());
        }
        if (form.getResumeLink() != null) {
            existingCandidate.setResumeLink(form.getResumeLink());
        }
        if (form.getInterviewScore() != null) {
            existingCandidate.setInterviewScore(form.getInterviewScore());
        }
        if (form.getStatus() != null) {
            existingCandidate.setStatus(Candidate.CandidateStatus.valueOf(form.getStatus()));
        }
        return existingCandidate;
    }
}
