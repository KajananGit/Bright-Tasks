package com.example.to_do_list.models;

public enum TaskStatus {
    TODO("To Do"),
    DOING("Doing"),
    DONE("Done");

    final String displayName;


    TaskStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getTaskStatus(){
        return displayName;
    };

}
