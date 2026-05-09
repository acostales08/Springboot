package com.crudapplication2.application2.model.response.msResponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MSResponse {
    private HttpStatus status;
    private Object body;
}
