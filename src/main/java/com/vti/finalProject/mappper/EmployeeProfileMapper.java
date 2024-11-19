package com.vti.finalProject.mapper;

import com.vti.finalProject.dto.EmployeeProfileDto;
import com.vti.finalProject.entity.EmployeeProfile;
import com.vti.finalProject.form.EmployeeProfileCreateForm;

public class EmployeeProfileMapper {

    public static EmployeeProfile map(EmployeeProfileCreateForm form) {
        EmployeeProfile profile = new EmployeeProfile();
        profile.setJobTitle(form.getJobTitle());
        profile.setStatus(EmployeeProfile.Status.valueOf(form.getStatus()));
        profile.setHireDate(form.getHireDate());
        return profile;
    }

    public static EmployeeProfileDto map(EmployeeProfile profile) {
        EmployeeProfileDto dto = new EmployeeProfileDto();
        dto.setProfileId(profile.getProfileId());
        dto.setUserId(profile.getUser().getId());
        dto.setUserName(profile.getUser().getFullName());
        dto.setDepartmentId(profile.getDepartment().getDepartmentId());
        dto.setDepartmentName(profile.getDepartment().getDepartmentName());
        dto.setJobTitle(profile.getJobTitle());
        dto.setStatus(profile.getStatus().toString());
        dto.setHireDate(profile.getHireDate());
        return dto;
    }
}
