package com.vti.finalProject.service;

import com.vti.finalProject.dto.UserDto;
import com.vti.finalProject.entity.Position;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.form.UserCreateForm;
import com.vti.finalProject.form.UserUpdateForm;
import com.vti.finalProject.mappper.UserMapper;
import com.vti.finalProject.repository.PositionRepository;
import com.vti.finalProject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PositionRepository positionRepository;

    @Override
    public UserDto create(UserCreateForm form) {
        User user = UserMapper.map(form);
        Position position = positionRepository.findById(form.getPositionId())
                .orElseThrow(() -> new EntityNotFoundException("Position not found"));
        user.setPosition(position);
        user = userRepository.save(user);
        return UserMapper.map(user);
    }

    @Override
    public UserDto searchByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user != null ? UserMapper.map(user) : null;
    }

    @Override
    public UserDto searchById(long id) {
        User user = userRepository.findById(id);
        return UserMapper.map(user);
    }

    @Override
    public void delete(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User with id " + id + " not found.");
        }
    }

    @Override
    public UserDto update(long id, UserUpdateForm form) {
        User user = userRepository.findById(id);

        user.setFullName(form.getFullName());
        user.setEmail(form.getEmail());
        user.setGender(form.getGender());
        user.setPhone(form.getPhone());

        if (form.getPositionId() != null) {
            Position position = positionRepository.findById(form.getPositionId())
                    .orElseThrow(() -> new EntityNotFoundException("Position not found"));
            user.setPosition(position);
        }

        user.setSkill(form.getSkill());

        if (form.getPassword() != null && !form.getPassword().isEmpty()) {
            user.setPassword(form.getPassword());
        }

        user = userRepository.save(user);
        return UserMapper.map(user);
    }
}