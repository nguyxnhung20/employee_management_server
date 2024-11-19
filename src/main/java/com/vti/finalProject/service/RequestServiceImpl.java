package com.vti.finalProject.service;

import com.vti.finalProject.dto.RequestDTO;
import com.vti.finalProject.entity.Request;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.form.RequestCreateForm;
import com.vti.finalProject.form.RequestUpdateForm;
import com.vti.finalProject.mappper.RequestMapper;
import com.vti.finalProject.repository.RequestRepository;
import com.vti.finalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public RequestDTO createRequest(RequestCreateForm form) {
        Optional<User> user = userRepository.findById(form.getUserId());
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        Request request = requestMapper.toEntity(form);
        request.setUser(user.get());

        request = requestRepository.save(request);

        return requestMapper.toDTO(request);
    }

    @Transactional
    @Override
    public RequestDTO updateRequest(RequestUpdateForm form) {
        Optional<Request> existingRequest = requestRepository.findById(form.getRequestId());
        if (existingRequest.isEmpty()) {
            throw new RuntimeException("Request not found");
        }

        Request updatedRequest = requestMapper.toEntity(form, existingRequest.get());
        updatedRequest = requestRepository.save(updatedRequest);

        return requestMapper.toDTO(updatedRequest);
    }

    @Override
    public List<RequestDTO> getAllRequests() {
        return requestRepository.findAll().stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RequestDTO getRequestById(Long requestId) {
        Optional<Request> request = requestRepository.findById(requestId);
        if (request.isEmpty()) {
            throw new RuntimeException("Request not found");
        }
        return requestMapper.toDTO(request.get());
    }
}
