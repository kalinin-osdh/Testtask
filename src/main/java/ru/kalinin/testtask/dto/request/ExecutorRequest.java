package ru.kalinin.testtask.dto.request;

import jakarta.validation.constraints.NotNull;

public record ExecutorRequest(
        @NotNull
        Long executorId
) {
}
