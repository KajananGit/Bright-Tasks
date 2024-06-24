package com.example.to_do_list.service;

import com.example.to_do_list.models.Task;
import com.example.to_do_list.models.User;
import com.example.to_do_list.repositories.TaskRepository;
import com.example.to_do_list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user, long id){
        User userUpdate = userRepository.findById(id).get();
        userUpdate.setUserName(user.getUserName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        userRepository.save(userUpdate);
        return userUpdate;
    }

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);

    }

    public void deleteUserById(long id){
        User user = userRepository.findById(id).get();
        for(Task task : user.getTasks()){
            taskRepository.delete(task);
        }
        userRepository.deleteById(id);
    }

}
