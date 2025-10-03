package com.example.apps.controller;



import com.example.apps.model.Task;
import com.example.apps.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("")
@Tag(name = "Task Management", description = "APIs for managing tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> createTask(@RequestParam String title,
                                           @RequestParam String description,
                                           @RequestParam String dueDate) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(java.time.LocalDate.parse(dueDate));
        task.setStatus(Task.Status.PENDING);
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> getTasks(@RequestParam Optional<Task.Status> status) {
        return ResponseEntity.ok(taskService.getAllTasks(status));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Task> completeTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.markAsCompleted(id));
    }
}
