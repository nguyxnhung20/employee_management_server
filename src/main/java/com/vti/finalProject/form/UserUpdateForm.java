package com.vti.finalProject.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateForm {
    private String fullName;
    private String email;
    private String gender;
    private String phone;
    private Long positionId;
    private String skill;
    private String password;
}