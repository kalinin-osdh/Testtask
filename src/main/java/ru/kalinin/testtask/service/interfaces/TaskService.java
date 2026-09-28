package ru.kalinin.testtask.service.interfaces;

import ru.kalinin.testtask.dto.request.ExecutorRequest;
import ru.kalinin.testtask.dto.request.StatusRequest;
import ru.kalinin.testtask.dto.request.TaskRequest;
import ru.kalinin.testtask.dto.response.TaskResponse;
import ru.kalinin.testtask.entity.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse addTask(TaskRequest request);

    TaskResponse addExecutor(Long id, ExecutorRequest request);

    TaskResponse changeStatus(Long id, StatusRequest request);

    Task getById(Long id);
}
