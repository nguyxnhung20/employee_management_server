package com.vti.finalProject.service;

import com.vti.finalProject.dto.UserDto;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.form.UserCreateForm;
import com.vti.finalProject.form.UserUpdateForm;

import com.vti.finalProject.mappper.UserMapper;
import com.vti.finalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto create(UserCreateForm form) {
        User user = UserMapper.map(form);
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
            System.out.println("User with id " + id + " not found.");
        }
    }

    @Override
    public UserDto update(long id, UserUpdateForm form) {
        User user = userRepository.findById(id);

        user.setFullName(form.getFullName());
        user.setEmail(form.getEmail());
        user.setGender(form.getGender());
        user.setPhone(form.getPhone());
        user.setPosition(form.getPosition());
        user.setSkill(form.getSkill());

        if (form.getPassword() != null && !form.getPassword().isEmpty()) {
            user.setPassword(form.getPassword());
        }

        user = userRepository.save(user);
        return UserMapper.map(user);
    }

}
