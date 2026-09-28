package ru.kalinin.testtask.dto.request;

import jakarta.validation.constraints.NotNull;
import ru.kalinin.testtask.entity.enums.TaskStatus;

public record StatusRequest(
        @NotNull
        TaskStatus status
) {
}
