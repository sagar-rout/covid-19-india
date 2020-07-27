package com.rout.covid19india.controller;

import java.time.LocalDateTime;

public class CustomErrorResponse {

    private String errorType;
    private String errorMessage;
    private LocalDateTime timestamp;
    private int status;

    public CustomErrorResponse(String errorType, String errorMessage) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public CustomErrorResponse setErrorType(String errorType) {
        this.errorType = errorType;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public CustomErrorResponse setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public CustomErrorResponse setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public CustomErrorResponse setStatus(int status) {
        this.status = status;
        return this;
    }
}
