package com.vti.finalProject.form;

import com.vti.finalProject.entity.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUpdateForm {

    private Long requestId;
    private Request.Status status;
    private boolean approvedByManager;
    private boolean approvedByAdmin;
}
