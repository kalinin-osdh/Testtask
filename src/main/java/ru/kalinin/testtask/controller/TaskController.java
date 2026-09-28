package ru.kalinin.testtask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kalinin.testtask.entity.Task;
import ru.kalinin.testtask.service.interfaces.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    public ResponseEntity<List<Task>> getAllTasks() {
        return null;
    }

    public ResponseEntity<Task> getTaskById(Long id) {
        return null;
    }

    public ResponseEntity<Task> addTask() {
        return null;
    }

    public ResponseEntity<Task> addExecutorForTask() {
        return null;
    }

    public ResponseEntity<Task> changeTaskStatus() {
        return null;
    }
}
