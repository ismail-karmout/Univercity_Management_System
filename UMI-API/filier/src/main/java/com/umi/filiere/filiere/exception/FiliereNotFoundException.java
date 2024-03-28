package com.umi.filiere.filiere.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FiliereNotFoundException extends RuntimeException {

    public FiliereNotFoundException(String message) {
        super(message);
    }
}
