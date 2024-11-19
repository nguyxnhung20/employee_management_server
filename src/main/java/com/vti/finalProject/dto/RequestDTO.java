package com.vti.finalProject.dto;

import com.vti.finalProject.entity.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {

    private Long requestId;
    private Long userId;
    private String requestType;
    private String requestDetail;
    private Request.Status status;
    private boolean approvedByManager;
    private boolean approvedByAdmin;

}
