package com.example.to_do_list.models;

public enum TaskType {
    WORK("Work"),
    SCHOOL("School"),
    HOBBY("Hobby"),
    SPORT("Sport");

    final String displayName;


    TaskType(String displayName) {
        this.displayName = displayName;
    }

    public String getTaskType(){
        return displayName;
    };

}
