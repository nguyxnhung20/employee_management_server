package com.vti.finalProject.service;

import com.vti.finalProject.dto.CandidateDTO;
import com.vti.finalProject.form.CandidateCreateForm;
import com.vti.finalProject.form.CandidateUpdateForm;

import java.util.List;

public interface CandidateService {
    CandidateDTO createCandidate(CandidateCreateForm form);
    CandidateDTO updateCandidate(Long candidateId, CandidateUpdateForm form);
    void deleteCandidate(Long candidateId);
    CandidateDTO getCandidate(Long candidateId);
    List<CandidateDTO> getAllCandidates();
}
