package com.vti.finalProject.service;

import com.vti.finalProject.entity.Position;
import com.vti.finalProject.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final PositionRepository positionRepository;

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Position findByPositionName(String positionName) {
        return positionRepository.findByPositionName(positionName);
    }
}