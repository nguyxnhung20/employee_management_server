package com.vti.finalProject.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ErrorResponse {
    private final String timestamp;
    private final String message;
    private Map<String, String> errors;

    public ErrorResponse(String message) {
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
    }

    public ErrorResponse(String message, Map<String, String> errors) {
        this(message);
        this.errors = errors;
    }
}