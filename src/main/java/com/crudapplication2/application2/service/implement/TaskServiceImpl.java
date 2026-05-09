package com.crudapplication2.application2.service.implement;

import com.crudapplication2.application2.model.TaskEntity;
import com.crudapplication2.application2.model.request.TaskRequestdto;
import com.crudapplication2.application2.model.response.msResponse.MSResponse;
import com.crudapplication2.application2.repository.TaskRepository;
import com.crudapplication2.application2.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.crudapplication2.application2.utilities.Constant.*;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public MSResponse addTask(TaskRequestdto request){
        TaskEntity task = TaskEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus())
                .build();
        repository.save(task);
        return MSResponse.builder()
                .status(HttpStatus.CREATED)
                .body(RESPONSE_SUCCESS_MESSAGE)
                .build();
    }


    @Override
    public MSResponse updateTask(long id, TaskRequestdto request){
        TaskEntity task = repository.findById(id).orElse(null);
        if (task == null) {
            return MSResponse.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .body(RESPONSE_NOT_FOUND)
                    .build();
        }
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        repository.save(task);

        return MSResponse.builder()
                .status(HttpStatus.OK)
                .body(RESPONSE_UPDATE_SUCCESS_MESSAGE)
                .build();
    }

    @Override
    public MSResponse getAllTasks(){
        List<TaskEntity> tasks = repository.findAll();
        if(tasks.isEmpty()){
            return MSResponse.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .body(RESPONSE_NOT_FOUND)
                    .build();
        }
        return MSResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .body(tasks)
                .build();
    }

    @Override
    public MSResponse deleteTask(long id){
        TaskEntity task = repository.findById(id).orElse(null);
        if (task == null) {
            return MSResponse.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .body(RESPONSE_NOT_FOUND)
                    .build();
        }
        repository.delete(task);
        return MSResponse.builder()
                .status(HttpStatus.OK)
                .body("success")
                .build();
    }
}
