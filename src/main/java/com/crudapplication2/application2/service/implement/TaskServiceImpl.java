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

    private final TaskRepository taskRepository;

    @Override
    public MSResponse addTask(TaskRequestdto request){
        MSResponse msResponse = new MSResponse();
        taskRepository.save(request);
        msResponse.setStatus(HttpStatus.CREATED);
        msResponse.setBody(RESPONSE_SUCCESS_MESSAGE);
        return msResponse;
    }


    @Override
    public MSResponse updateTask(int id, TaskRequestdto request){
        MSResponse msResponse = new MSResponse();
        TaskRequestdto task = taskRepository.findById(id).orElse(null);
        if(task == null){
            msResponse.setStatus(HttpStatus.NOT_FOUND);
            msResponse.setBody(RESPONSE_NOT_FOUND);
        }
        taskRepository.save(request);
        msResponse.setStatus(HttpStatus.CREATED);
        msResponse.setBody(RESPONSE_UPDATE_SUCCESS_MESSAGE);
        return msResponse;
    }

    @Override
    public MSResponse getAllTasks(){
        MSResponse msResponse = new MSResponse();
        List<TaskRequestdto> tasks = taskRepository.findAll();
        if(tasks.isEmpty()){
            msResponse.setStatus(HttpStatus.NOT_FOUND);
            msResponse.setBody(RESPONSE_NOT_FOUND);
        }
        msResponse.setStatus(HttpStatus.OK);
        msResponse.setBody(tasks);
        return msResponse;
    }

    @Override
    public MSResponse deleteTask(int id){
        MSResponse msResponse = new MSResponse();
        TaskRequestdto task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            msResponse.setStatus(HttpStatus.NOT_FOUND);
            msResponse.setBody(RESPONSE_NOT_FOUND);
        }
        taskRepository.delete(task);
        msResponse.setStatus(HttpStatus.OK);
        msResponse.setBody("success");
        return msResponse;
    }
}
