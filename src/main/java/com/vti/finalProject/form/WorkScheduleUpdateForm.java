package com.vti.finalProject.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class WorkScheduleUpdateForm {
    @NotNull(message = "Schedule ID is required")
    private Long scheduleId;

    private LocalDate workDate;
    private Integer workHours;
    private String status;
}
