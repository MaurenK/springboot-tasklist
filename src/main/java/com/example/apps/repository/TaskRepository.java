package com.example.apps.repository;

            // Import your Task entity class
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apps.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Custom method to find tasks by status
    List<Task> findByStatus(Task.Status status);
}

