package ru.kalinin.testtask.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kalinin.testtask.dto.request.ExecutorRequest;
import ru.kalinin.testtask.dto.request.StatusRequest;
import ru.kalinin.testtask.dto.request.TaskRequest;
import ru.kalinin.testtask.dto.response.TaskResponse;
import ru.kalinin.testtask.entity.Task;
import ru.kalinin.testtask.service.interfaces.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping()
    // todo пагинация
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping()
    public ResponseEntity<TaskResponse> addTask(
            @Valid @RequestBody TaskRequest request
            ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.addTask(request));
    }

    @PatchMapping("/{id}/executor")
    public ResponseEntity<TaskResponse> addExecutorForTask(
            @PathVariable Long id,
            @Valid @RequestBody ExecutorRequest request
    ) {
        return ResponseEntity.ok(taskService.addExecutor(id, request));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskResponse> changeTaskStatus(
            @PathVariable Long id,
            @Valid @RequestBody StatusRequest request
    ) {
        return ResponseEntity.ok(taskService.changeStatus(id, request));
    }
}
