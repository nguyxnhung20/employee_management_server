package com.vti.finalProject.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = DepartmentPkExistsValidator.class)
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface DepartmentPkExists {
    String message() default "{department.pk.Exists.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
