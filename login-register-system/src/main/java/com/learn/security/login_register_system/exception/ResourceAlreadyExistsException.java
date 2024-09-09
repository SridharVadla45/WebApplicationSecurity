package com.learn.security.login_register_system.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends RuntimeException{


    public ResourceAlreadyExistsException(String resource, String field) {
        super(String.format("%s with %s already exists", resource, field));
    }
}
