package com.vti.finalProject.controller;

import com.vti.finalProject.dto.RequestDTO;
import com.vti.finalProject.form.RequestCreateForm;
import com.vti.finalProject.form.RequestUpdateForm;
import com.vti.finalProject.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping
    public ResponseEntity<RequestDTO> createRequest(@RequestBody RequestCreateForm form) {
        RequestDTO createdRequest = requestService.createRequest(form);
        return ResponseEntity.ok(createdRequest);
    }

    @PutMapping("/{requestId}")
    public ResponseEntity<RequestDTO> updateRequest(
            @PathVariable Long requestId,
            @RequestBody RequestUpdateForm form) {
        form.setRequestId(requestId);
        RequestDTO updatedRequest = requestService.updateRequest(form);
        return ResponseEntity.ok(updatedRequest);
    }

    @GetMapping
    public ResponseEntity<List<RequestDTO>> getAllRequests() {
        List<RequestDTO> requests = requestService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<RequestDTO> getRequestById(@PathVariable Long requestId) {
        RequestDTO request = requestService.getRequestById(requestId);
        return ResponseEntity.ok(request);
    }
}
