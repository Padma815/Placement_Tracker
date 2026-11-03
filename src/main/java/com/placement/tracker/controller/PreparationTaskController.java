package com.placement.tracker.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.tracker.model.PreparationTask;
import com.placement.tracker.service.PreparationTaskService;

/**
 * REST Controller for PreparationTask.
 * 
 * Exposes HTTP endpoints for frontend JavaScript to perform CRUD operations.
 * Base URL: http://localhost:8080/api/tasks
 */
@RestController
@RequestMapping("/api/tasks")
public class PreparationTaskController {

    // Reference to the service layer
    private final PreparationTaskService taskService;

    // Constructor Injection: Spring injects the PreparationTaskService bean
    public PreparationTaskController(PreparationTaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * 1. Add a new preparation task.
     * HTTP Method: POST
     * Endpoint: /api/tasks
     */
    @PostMapping
    public PreparationTask addTask(@RequestBody PreparationTask task) {
        return taskService.addTask(task);
    }

    /**
     * 2. Retrieve all preparation tasks.
     * HTTP Method: GET
     * Endpoint: /api/tasks
     */
    @GetMapping
    public List<PreparationTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * 3. Delete a task by ID.
     * HTTP Method: DELETE
     * Endpoint: /api/tasks/{id}
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
