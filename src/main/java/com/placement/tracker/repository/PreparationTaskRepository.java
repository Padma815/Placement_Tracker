package com.placement.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.placement.tracker.model.PreparationTask;

/**
 * Repository interface for managing PreparationTask entities in MySQL.
 * 
 * Extending JpaRepository provides built-in CRUD operations
 * without writing any boilerplate implementation code or SQL queries.
 */
@Repository
public interface PreparationTaskRepository extends JpaRepository<PreparationTask, Long> {
    // No additional methods needed for basic CRUD operations!
    // JpaRepository automatically provides:
    // - save(PreparationTask task)       -> Insert or Update a task
    // - findById(Long id)                -> Fetch a task by primary key
    // - findAll()                        -> Fetch all tasks as a List
    // - deleteById(Long id)              -> Delete a task by primary key
    // - count()                          -> Count total tasks
    // - existsById(Long id)              -> Check if a task exists
}
