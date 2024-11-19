package com.vti.finalProject.service;
import com.vti.finalProject.dto.CandidateDTO;
import com.vti.finalProject.entity.Candidate;
import com.vti.finalProject.form.CandidateCreateForm;
import com.vti.finalProject.form.CandidateUpdateForm;
import com.vti.finalProject.mappper.CandidateMapper;
import com.vti.finalProject.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public CandidateDTO createCandidate(CandidateCreateForm form) {
        Candidate candidate = CandidateMapper.toEntity(form);
        Candidate savedCandidate = candidateRepository.save(candidate);
        return CandidateMapper.toDTO(savedCandidate);
    }

    @Override
    public CandidateDTO updateCandidate(Long candidateId, CandidateUpdateForm form) {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
        candidate = CandidateMapper.toEntity(form, candidate);
        Candidate updatedCandidate = candidateRepository.save(candidate);
        return CandidateMapper.toDTO(updatedCandidate);
    }

    @Override
    public void deleteCandidate(Long candidateId) {
        candidateRepository.deleteById(candidateId);
    }

    @Override
    public CandidateDTO getCandidate(Long candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
        return CandidateMapper.toDTO(candidate);
    }

    @Override
    public List<CandidateDTO> getAllCandidates() {
        return candidateRepository.findAll().stream()
                .map(CandidateMapper::toDTO)
                .collect(Collectors.toList());
    }
}
