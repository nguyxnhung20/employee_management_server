package com.vti.finalProject.service;

import com.vti.finalProject.dto.RequestDTO;
import com.vti.finalProject.form.RequestCreateForm;
import com.vti.finalProject.form.RequestUpdateForm;

import java.util.List;

public interface RequestService {
    RequestDTO createRequest(RequestCreateForm form);
    RequestDTO updateRequest(RequestUpdateForm form);
    List<RequestDTO> getAllRequests();
    RequestDTO getRequestById(Long requestId);
}
