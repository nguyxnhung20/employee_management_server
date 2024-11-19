package com.vti.finalProject.form;

import com.vti.finalProject.entity.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCreateForm {

    private Long userId;
    private String requestType;
    private String requestDetail;
    private Request.Status status = Request.Status.PENDING;
    private boolean approvedByManager;
    private boolean approvedByAdmin;

}
