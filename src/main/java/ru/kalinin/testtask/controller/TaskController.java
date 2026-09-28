package ru.kalinin.testtask.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        return null;
    }

    @PostMapping()
    public ResponseEntity<TaskResponse> addTask(
            @Valid @RequestBody TaskRequest request
            ) {
        return null;
    }

    @PatchMapping("/{id}/executor")
    public ResponseEntity<TaskResponse> addExecutorForTask(
            @PathVariable Long id,
            @Valid @RequestBody ExecutorRequest request
    ) {
        return null;
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskResponse> changeTaskStatus(
            @PathVariable Long id,
            @Valid @RequestBody StatusRequest request
    ) {
        return null;
    }
}
