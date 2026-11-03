package com.placement.tracker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.placement.tracker.model.PreparationTask;
import com.placement.tracker.repository.PreparationTaskRepository;

/**
 * Service class for PreparationTask.
 * 
 * Sits between the Controller (presentation layer) and Repository (data layer).
 * Contains the business logic and orchestrates data operations.
 */
@Service
public class PreparationTaskService {

    // Reference to the repository for database access
    private final PreparationTaskRepository taskRepository;

    // Constructor Injection: Spring automatically passes the PreparationTaskRepository bean here
    public PreparationTaskService(PreparationTaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // 1. Add a new task or save changes to an existing task
    public PreparationTask addTask(PreparationTask task) {
        return taskRepository.save(task);
    }

    // 2. Retrieve all preparation tasks from the database
    public List<PreparationTask> getAllTasks() {
        return taskRepository.findAll();
    }

    // 3. Delete a task by its unique ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
