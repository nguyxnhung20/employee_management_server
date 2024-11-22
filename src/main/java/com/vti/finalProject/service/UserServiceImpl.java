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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateForm form) {
        User user = UserMapper.map(form);
        Position position = positionRepository.findById(form.getPositionId())
                .orElseThrow(() -> new EntityNotFoundException("Position not found"));
        user.setPosition(position);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new EntityNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword()).roles("USER").build();
    }
}