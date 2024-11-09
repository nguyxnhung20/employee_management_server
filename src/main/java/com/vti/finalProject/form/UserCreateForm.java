package com.vti.finalProject.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserCreateForm {
    @NotBlank
    @Length(max = 255)
    private String fullName;

    @NotBlank
    @Email
    @Length(max = 100)
    private String email;

    @NotBlank
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be 'Male', 'Female', or 'Other'")
    private String gender;

    @NotBlank
    @Length(max = 20)
    private String phone;

    @NotBlank
    @Length(max = 100)
    private String position;

    @NotBlank
    @Length(max = 200)
    private String skill;

    @NotBlank
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;
}
