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

//        Users

        User user1 = new User("John", "Johnny5@gmail.com", "jhon123");
        userRepository.save(user1);

        User user2 = new User("Kajanan", "KajaWork@gmail.com", "Free@25");
        userRepository.save(user2);

        User user3 = new User("Tommy", "TomGrey@hotmail.com", "Gsdv!£bdfgb");
        userRepository.save(user3);

        User user4 = new User("Michelle", "MichelleJ2000@outlook.co.uk", "fgbSAff123");
        userRepository.save(user4);

//        Tasks

        Task task1 = new Task("Coding Lesson 3", "Complete Java lesson 3 (Functions/Methods)", TaskType.SCHOOL, LocalDate.of(2024,7, 15), user1);
        taskRepository.save(task1);

        Task task2 = new Task("Write Test-cases", "Create test-cases for the final year project", TaskType.SCHOOL, LocalDate.of(2024, 7, 15), user1);
        taskRepository.save(task2);

        Task task3 = new Task("Gym Session", "Finish Ab workout", TaskType.SPORT, LocalDate.of(2024,7, 15), user1);
        taskRepository.save(task3);



        Task task4 = new Task("Cardio", "Join the cardio session at 12pm!", TaskType.SPORT, LocalDate.of(2024,6, 27), user2);
        taskRepository.save(task4);

        Task task5 = new Task("Video Interview", "Finish Video interview stage for Capgemini", TaskType.WORK, LocalDate.of(2024,7, 20), user2);
        taskRepository.save(task5);


        Task task6 = new Task("Driving Lesson", "Finish final driving lesson", TaskType.SCHOOL, LocalDate.of(2024,9, 5), user3);
        taskRepository.save(task6);

        Task task7 = new Task("Book driving test", "Book driving test for september", TaskType.SCHOOL, LocalDate.of(2024,8, 13), user3);
        taskRepository.save(task7);



        Task task8 = new Task("Read", "Read chapter 7 of Atomic Habits", TaskType.HOBBY, LocalDate.of(2024,6, 28), user4);
        taskRepository.save(task8);

        Task task9 = new Task("Practise Tennis", "Go to Tennis lesson for beginners at Luton Sport Activity Center", TaskType.SPORT, LocalDate.of(2024,7, 9), user4);
        taskRepository.save(task9);

        Task task10 = new Task("Book flight", "Book flight tickets to Sri Lanka", TaskType.HOBBY, LocalDate.of(2024,10, 28), user4);
        taskRepository.save(task10);



    }

}
