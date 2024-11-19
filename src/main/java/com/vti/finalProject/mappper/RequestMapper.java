package com.vti.finalProject.mappper;

import com.vti.finalProject.dto.RequestDTO;
import com.vti.finalProject.entity.Request;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.form.RequestCreateForm;
import com.vti.finalProject.form.RequestUpdateForm;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RequestMapper {

    public Request toEntity(RequestCreateForm form) {
        Request request = new Request();
        request.setUser(new User());
        request.setRequestType(form.getRequestType());
        request.setRequestDetail(form.getRequestDetail());
        request.setStatus(form.getStatus());
        request.setApprovedByManager(form.isApprovedByManager());
        request.setApprovedByAdmin(form.isApprovedByAdmin());
        request.setCreatedAt(LocalDateTime.now());
        return request;
    }

    public Request toEntity(RequestUpdateForm form, Request existingRequest) {
        existingRequest.setStatus(form.getStatus());
        existingRequest.setApprovedByManager(form.isApprovedByManager());
        existingRequest.setApprovedByAdmin(form.isApprovedByAdmin());
        existingRequest.setUpdatedAt(LocalDateTime.now());
        return existingRequest;
    }

    public RequestDTO toDTO(Request request) {
        RequestDTO dto = new RequestDTO();
        dto.setRequestId(request.getRequestId());
        dto.setUserId(request.getUser().getId());
        dto.setRequestType(request.getRequestType());
        dto.setRequestDetail(request.getRequestDetail());
        dto.setStatus(request.getStatus());
        dto.setApprovedByManager(request.isApprovedByManager());
        dto.setApprovedByAdmin(request.isApprovedByAdmin());
        return dto;
    }
}
