package ru.kalinin.testtask.dto.response;

import java.util.List;

public record PageResponse<T>(
        List<T> content,
        int page,
        int size,
        int totalPages,
        long totalElements
) {
}
