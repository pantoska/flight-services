package com.project.flight.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = {ServiceException.class})
    protected ResponseEntity<Object> handleServiceException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse;
        HttpStatus status;
        if(ex instanceof ServiceException) {
            bodyOfResponse = ((ServiceException) ex).getMessage();
            status = ((ServiceException) ex).getStatus();
            log.warn(bodyOfResponse);
        } else {
            bodyOfResponse = ex.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error(bodyOfResponse);
        }
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), status, request);
    }
}
