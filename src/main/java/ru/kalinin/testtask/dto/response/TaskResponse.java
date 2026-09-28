package ru.kalinin.testtask.dto.response;

import ru.kalinin.testtask.entity.enums.TaskStatus;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status,
        Long executor_id
) {
}
