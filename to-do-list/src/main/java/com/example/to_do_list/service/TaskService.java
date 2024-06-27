package com.example.to_do_list.service;

import com.example.to_do_list.models.Task;
import com.example.to_do_list.models.TaskStatus;
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
            Object convertedValue = convertValueToFieldType(field, value);
            ReflectionUtils.setField(field, taskUpdate, convertedValue);
        });
        return taskRepository.save(taskUpdate);
    }

    private Object convertValueToFieldType(Field field, Object value) {
        if (field.getType().isEnum()) {
            return Enum.valueOf((Class<Enum>) field.getType(), value.toString());
        }
        return value;
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

    public List<Task> getTasksByUserId(long id){
        return taskRepository.findByUserId(id);
    }

    public List<Task> getTasksByStatus(TaskStatus status){
        return taskRepository.findByTaskStatus(status);
    }

}
