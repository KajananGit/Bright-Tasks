package com.example.to_do_list.service;

import com.example.to_do_list.models.Task;
import com.example.to_do_list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void deleteTaskById(long id){
        taskRepository.deleteById(id);
    }

}
