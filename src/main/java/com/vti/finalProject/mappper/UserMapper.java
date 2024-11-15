package com.vti.finalProject.mappper;

import com.vti.finalProject.dto.PositionDto;
import com.vti.finalProject.dto.UserDto;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.form.UserCreateForm;

public class UserMapper {

    public static User map(UserCreateForm form) {
        User user = new User();
        user.setFullName(form.getFullName());
        user.setEmail(form.getEmail());
        user.setGender(form.getGender());
        user.setPhone(form.getPhone());
        user.setSkill(form.getSkill());
        user.setPassword(form.getPassword());
        return user;
    }

    public static UserDto map(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setGender(user.getGender());
        dto.setPhone(user.getPhone());
        dto.setSkill(user.getSkill());

        if (user.getPosition() != null) {
            PositionDto positionDto = new PositionDto();
            positionDto.setId(user.getPosition().getPositionId());
            positionDto.setPositionName(user.getPosition().getPositionName());
            positionDto.setLevel(user.getPosition().getLevel().toString());
            dto.setPosition(positionDto);
        }

        return dto;
    }
}
