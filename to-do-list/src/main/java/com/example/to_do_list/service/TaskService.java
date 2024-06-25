package com.example.to_do_list.service;

import com.example.to_do_list.models.Task;
import com.example.to_do_list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Task task, long id){
        Task taskUpdate = taskRepository.findById(id).get();
        taskUpdate.setTaskTitle(task.getTaskTitle());
        taskUpdate.setTaskDesc(task.getTaskDesc());
        taskUpdate.setTaskType(task.getTaskType());
        taskUpdate.setTaskStatus(task.getTaskStatus());
        taskUpdate.setDeadline(task.getDeadline());
        taskRepository.save(taskUpdate);
        return taskUpdate;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(long id){
        return taskRepository.findById(id);
    }

    public void deleteTaskById(long id){
        taskRepository.deleteById(id);
    }

}
