package com.example.to_do_list.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String taskTitle;

    @Column(name = "description")
    private String taskDesc;

    @Column(name = "type")
    private TaskType taskType;

    @Column(name = "status")
    private TaskStatus taskStatus;

    @Column(name = "due")
    private LocalDate deadline;

    @JsonIgnoreProperties("tasks")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


//    CONSTRUCTOR
    public Task(){};

    public Task(String title, String desc, TaskType type, LocalDate date, User user){
        this.taskTitle = title;
        this.taskDesc = desc;
        this.taskType = type;
        this.taskStatus = TaskStatus.TODO;
        this.deadline = date;
        this.user = user;
    }


//    GETTERS & SETTERS


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public User getUser() {
        return user;
    }
}
