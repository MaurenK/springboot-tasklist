package com.example.apps.service;



import com.example.apps.service.TaskService;
import com.example.apps.model.Task;
import com.example.apps.repository.TaskRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor  // Lombok annotation to generate constructor with required fields
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        task.setStatus(Task.Status.PENDING);  // default status
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(Optional<Task.Status> status) {
        return status.map(taskRepository::findByStatus)
                     .orElseGet(taskRepository::findAll);
    }

    public Task markAsCompleted(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(Task.Status.COMPLETED);
        return taskRepository.save(task);
    }
}


