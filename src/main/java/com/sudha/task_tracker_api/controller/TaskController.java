package com.sudha.task_tracker_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @GetMapping("/")
    public String home() {
        return "Task Tracker API is running successfully!";
    }    
}
