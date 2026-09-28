package ru.kalinin.testtask.dto.mapper;

import org.springframework.stereotype.Component;
import ru.kalinin.testtask.dto.request.TaskRequest;
import ru.kalinin.testtask.dto.response.TaskResponse;
import ru.kalinin.testtask.entity.Task;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {

    public Task toEntity(TaskRequest taskRequest) {
        return Task.builder()
                .title(taskRequest.title())
                .description(taskRequest.description())
                .build();
    }

    public List<TaskResponse> toResponse(List<Task> tasks) {
        if (tasks.isEmpty())
                return List.of();

        List<TaskResponse> responses = new ArrayList<>();

        for (Task task : tasks) {
            responses.add(toResponse(task));
        }

        return responses;
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getExecutor() == null ? null : task.getExecutor().getId()
        );
    }
}
