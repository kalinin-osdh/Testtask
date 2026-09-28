package ru.kalinin.testtask.dto.request;

public record PageTaskRequest(
        Integer page,
        Integer size,
        String sortBy,
        String sortDirection
) {
}
