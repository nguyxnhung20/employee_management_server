package com.vti.finalProject.controller;

import com.vti.finalProject.dto.CandidateDTO;
import com.vti.finalProject.service.CandidateService;
import com.vti.finalProject.form.CandidateCreateForm;
import com.vti.finalProject.form.CandidateUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CandidateDTO createCandidate(@RequestBody CandidateCreateForm form) {
        return candidateService.createCandidate(form);
    }

    @PutMapping("/{candidateId}")
    public CandidateDTO updateCandidate(@PathVariable Long candidateId, @RequestBody CandidateUpdateForm form) {
        return candidateService.updateCandidate(candidateId, form);
    }

    @DeleteMapping("/{candidateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCandidate(@PathVariable Long candidateId) {
        candidateService.deleteCandidate(candidateId);
    }

    @GetMapping("/{candidateId}")
    public CandidateDTO getCandidate(@PathVariable Long candidateId) {
        return candidateService.getCandidate(candidateId);
    }

    @GetMapping
    public List<CandidateDTO> getAllCandidates() {
        return candidateService.getAllCandidates();
    }
}
