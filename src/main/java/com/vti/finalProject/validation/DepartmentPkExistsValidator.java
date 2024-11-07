package com.vti.finalProject.validation;

import com.vti.finalProject.repository.DepartmentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DepartmentPkExistsValidator implements ConstraintValidator<DepartmentPkExists, Integer> {
    private final DepartmentRepository departmentRepository;

    @Override
    public boolean isValid(Integer departmentId, ConstraintValidatorContext context) {
        if (departmentId == null) {
            return false;
        }
        return departmentRepository.existsById(departmentId);
    }
}
