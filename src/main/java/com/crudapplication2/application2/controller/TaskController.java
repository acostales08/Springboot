package com.crudapplication2.application2.controller;

import com.crudapplication2.application2.model.TaskEntity;
import com.crudapplication2.application2.model.request.TaskRequestdto;
import com.crudapplication2.application2.model.response.dto.TaskResponse;
import com.crudapplication2.application2.model.response.msResponse.MSResponse;
import com.crudapplication2.application2.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<Object> createTask(@RequestBody TaskRequestdto request) {
        MSResponse taskResponse = taskService.addTask(request);

        return ResponseEntity
                .status(taskResponse.getStatus())
                .body(taskResponse.getBody());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateTask(
            @PathVariable long id,
            @RequestBody TaskRequestdto request) {

        MSResponse taskResponse = taskService.updateTask(id, request);

        return ResponseEntity
                .status(taskResponse.getStatus())
                .body(taskResponse.getBody());
    }

    @GetMapping("/allTask")
    public ResponseEntity<Object> getAllTasks() {
        MSResponse taskResponse = taskService.getAllTasks();
        return ResponseEntity
                .status(taskResponse.getStatus())
                .body(taskResponse.getBody());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable long id) {
        MSResponse taskResponse = taskService.deleteTask(id);
        return ResponseEntity
                .status(taskResponse.getStatus())
                .body(taskResponse.getBody());
    }

}
