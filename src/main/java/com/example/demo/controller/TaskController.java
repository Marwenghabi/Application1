package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	 @Autowired
	    private TaskService taskService;

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody Task task) {
       
    	  taskService.sendTask(task);

        return ResponseEntity.ok("Task created and sent to app2");
    }
}
