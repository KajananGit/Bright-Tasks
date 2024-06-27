package com.example.to_do_list.repositories;

import com.example.to_do_list.models.Task;
import com.example.to_do_list.models.TaskStatus;
import com.example.to_do_list.models.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

//    filter by deadline
    @Query ("SELECT t FROM Task t ORDER BY t.deadline ASC")
    List<Task> sortByDeadline();

//  get tasks by user id
    List<Task> findByUserId(long id);

//    filter by status
    List<Task> findByTaskStatus(TaskStatus status);

//    filter by type
    List<Task> findByTaskType(TaskType type);

}
