package com.project.flight.error;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {
    HttpStatus status;

    public ServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return String.format("Exception message {%s}, code status {%s}", super.getMessage(), status);
    }
}
