package com.vti.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnResult {
    private int code;
    private String message;
    private Object data;

    public ReturnResult() {
        this.code = 1;
        this.message = "OK";
        this.data = null;
    }
}
