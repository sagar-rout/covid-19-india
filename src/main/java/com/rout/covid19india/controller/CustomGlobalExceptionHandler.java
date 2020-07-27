package com.rout.covid19india.controller;

import com.rout.covid19india.service.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * @author Sagar Rout (sagar@rout.dev)
 */
@RestControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<CustomErrorResponse> handleGenericBadRequestException(BadRequestException e) {
        CustomErrorResponse error = new CustomErrorResponse("BAD_REQUEST", e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}