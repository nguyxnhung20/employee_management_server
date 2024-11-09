package com.vti.finalProject.service;

import com.vti.finalProject.dto.UserDto;
import com.vti.finalProject.form.UserCreateForm;
import com.vti.finalProject.form.UserUpdateForm;

public interface UserService {
    UserDto create(UserCreateForm form);
    UserDto update(long id, UserUpdateForm form);
    void delete(long id);
    UserDto searchByEmail(String email);
    UserDto searchById(long id);
}
