package com.crudapplication2.application2.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestdto {
    private String title;
    private String description;
    private String status;
}
