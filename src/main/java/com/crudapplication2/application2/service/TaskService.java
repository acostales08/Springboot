package com.crudapplication2.application2.service;

import com.crudapplication2.application2.model.request.TaskRequestdto;
import com.crudapplication2.application2.model.response.msResponse.MSResponse;

public interface TaskService {
    MSResponse addTask(TaskRequestdto task);
    MSResponse updateTask(long id, TaskRequestdto task);
    MSResponse getAllTasks();
    MSResponse deleteTask(long id);
}
