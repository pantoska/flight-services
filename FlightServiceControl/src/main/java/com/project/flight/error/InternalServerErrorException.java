package com.project.flight.error;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ServiceException {
    public InternalServerErrorException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
