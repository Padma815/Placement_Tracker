package com.placement.tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity representing a preparation task in the placement tracker.
 * 
 * Maps directly to the 'preparation_tasks' table in MySQL.
 */
@Entity
@Table(name = "preparation_tasks")
public class PreparationTask {

    // Primary key with auto-increment in MySQL
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name or title of the preparation task (e.g., "Solve Two Sum", "Revise OS Deadlocks")
    private String taskName;

    // Subject/Category topic (e.g., "Data Structures", "Algorithms", "Operating Systems", "DBMS")
    private String topic;

    // Current preparation status (e.g., "Pending", "In Progress", "Completed")
    private String status;

    // 1. Default No-Argument Constructor (MANDATORY for JPA/Hibernate)
    public PreparationTask() {
    }

    // 2. Parameterized Constructor (Convenient for creating tasks without manually passing ID)
    public PreparationTask(String taskName, String topic, String status) {
        this.taskName = taskName;
        this.topic = topic;
        this.status = status;
    }

    // 3. Full Constructor (Helpful when updating an existing task that already has an ID)
    public PreparationTask(Long id, String taskName, String topic, String status) {
        this.id = id;
        this.taskName = taskName;
        this.topic = topic;
        this.status = status;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString() for easy debugging and logging
    @Override
    public String toString() {
        return "PreparationTask{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", topic='" + topic + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
