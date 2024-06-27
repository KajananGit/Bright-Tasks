package com.example.to_do_list.controller;

import com.example.to_do_list.models.Task;
import com.example.to_do_list.models.TaskStatus;
import com.example.to_do_list.models.TaskType;
import com.example.to_do_list.repositories.TaskRepository;
import com.example.to_do_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;


    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false, name = "taskStatus") TaskStatus status,
                                                  @RequestParam(required = false, name = "taskType") TaskType type) {
        if(status != null){
            return new ResponseEntity<>(taskService.getTasksByStatus(status), HttpStatus.OK);
        }
        else if(type != null){
            return new ResponseEntity<>(taskService.getTasksByType(type), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id){
        Optional<Task> task = taskService.getTaskById(id);
        if(task.isPresent()){
            return new ResponseEntity<>(task.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Map<String, Object> fields, @PathVariable long id){
        Optional<Task> taskToBeUpdated = taskService.getTaskById(id);
        if(taskToBeUpdated.isPresent()){
            return new ResponseEntity<>(taskService.updateTask(fields, id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteTaskById(@PathVariable long id){
        Optional<Task> task = taskService.getTaskById(id);
        if(task.isPresent()){
            taskService.deleteTaskById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable long id){
         return new ResponseEntity<>(taskService.getTasksByUserId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/sortByDeadline")
    public ResponseEntity<List<Task>> sortDeadline(){
        return new ResponseEntity<>(taskService.sortTaskByDeadline(), HttpStatus.OK);
    }

}
