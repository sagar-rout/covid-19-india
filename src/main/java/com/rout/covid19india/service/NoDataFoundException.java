package com.rout.covid19india.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sagar Rout
 */
import java.util.UUID;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {
        super();
    }

    public NoDataFoundException(String entity, UUID id) {
        super(String.format("Entity %s with %s not found", entity, id));
    }
}