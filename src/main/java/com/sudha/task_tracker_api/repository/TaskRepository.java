package com.sudha.task_tracker_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sudha.task_tracker_api.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
