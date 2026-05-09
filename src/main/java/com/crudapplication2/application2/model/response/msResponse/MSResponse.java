package com.crudapplication2.application2.model.response.msResponse;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@Data
public class MSResponse {
    private HttpStatus status;
    private Object body;
}
