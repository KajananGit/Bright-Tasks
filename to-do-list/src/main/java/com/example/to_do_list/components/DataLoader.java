package com.example.to_do_list.components;

import com.example.to_do_list.models.User;
import com.example.to_do_list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    public DataLoader() {}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("John");
        userRepository.save(user1);
    }

}
