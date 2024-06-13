package com.example.to_do_list.components;

import com.example.to_do_list.models.Task;
import com.example.to_do_list.models.TaskType;
import com.example.to_do_list.models.User;
import com.example.to_do_list.repositories.TaskRepository;
import com.example.to_do_list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    public DataLoader() {}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("John", "Johnny5@gmail.com", "jhon123");
        userRepository.save(user1);

        Task task1 = new Task("Coding Lesson 3", "Complete Java lesson 3 (Functions/Methods)", TaskType.SCHOOL, LocalDate.of(2024,7, 15), user1);
        taskRepository.save(task1);

    }

}
