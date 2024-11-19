package com.vti.finalProject.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class WorkScheduleCreateForm {
    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Work date is required")
    private LocalDate workDate;

    @Min(value = 0, message = "Work hours must be non-negative")
    @Max(value = 24, message = "Work hours cannot exceed 24")
    private Integer workHours;
}
