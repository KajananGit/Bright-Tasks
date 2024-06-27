package com.example.to_do_list.service;

import com.example.to_do_list.models.Task;
import com.example.to_do_list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Map<String, Object> fields, long id){
        Task taskUpdate = taskRepository.findById(id).get();
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Task.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, taskUpdate, value);
        });
        return taskRepository.save(taskUpdate);
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
