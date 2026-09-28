package ru.kalinin.testtask.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kalinin.testtask.dto.request.ExecutorRequest;
import ru.kalinin.testtask.dto.request.StatusRequest;
import ru.kalinin.testtask.dto.request.TaskRequest;
import ru.kalinin.testtask.dto.response.TaskResponse;
import ru.kalinin.testtask.repository.TaskRepository;
import ru.kalinin.testtask.service.interfaces.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public List<TaskResponse> getAllTasks() {
        return List.of();
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        return null;
    }

    @Override
    public TaskResponse addTask(TaskRequest request) {
        return null;
    }

    @Override
    public TaskResponse addExecutor(Long id, ExecutorRequest request) {
        return null;
    }

    @Override
    public TaskResponse changeStatus(Long id, StatusRequest request) {
        return null;
    }
}
