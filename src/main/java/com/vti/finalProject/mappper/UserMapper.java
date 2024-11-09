package com.vti.finalProject.mappper;

import com.vti.finalProject.dto.UserDto;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.form.UserCreateForm;

public class UserMapper {
    public static User map(UserCreateForm form) {
        var user = new User();
        user.setFullName(form.getFullName());
        user.setEmail(form.getEmail());
        user.setGender(form.getGender());
        user.setPhone(form.getPhone());
        user.setPosition(form.getPosition());
        user.setSkill(form.getSkill());
        user.setPassword(form.getPassword());
        return user;
    }

    public static UserDto map(User user) {
        var dto = new UserDto();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setGender(user.getGender());
        dto.setPhone(user.getPhone());
        dto.setPosition(user.getPosition());
        dto.setSkill(user.getSkill());

        dto.setDepartmentName(user.getDepartment() != null ? user.getDepartment().getDepartmentName() : null);

        return dto;
    }
}
