package com.sudha.task_tracker_api.controller;

import com.sudha.task_tracker_api.model.Task;
import com.sudha.task_tracker_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String home() {
        return "Task Tracker API is running successfully!";
    }    
    //Get all task
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(ResponseEntity::ok)
        .orElseGet(()-> ResponseEntity.notFound().build());

    }

    //create  new task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskRepository.save(task);
        return ResponseEntity.ok(savedTask);
    }
    //update an existing task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setDueDate(updatedTask.getDueDate());
            Task saved = taskRepository.save(task);
            return ResponseEntity.ok(saved);
        }).orElseGet(()-> ResponseEntity.notFound().build());
    }
    //Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletedTask(@PathVariable Long id){
        if(!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    }
    
    

