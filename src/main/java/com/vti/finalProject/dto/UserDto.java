package com.vti.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String fullName;
    private String email;
    private String gender;
    private String phone;
    private String position;
    private String skill;
    private String departmentName;
}
