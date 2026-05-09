package com.crudapplication2.application2.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MSException {
    private HttpStatus status;
    private String message;
}
