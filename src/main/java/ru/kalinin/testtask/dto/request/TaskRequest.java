package ru.kalinin.testtask.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskRequest(
        @NotBlank
        @Size(max = 100)
        String title,
        @NotBlank
        String description
) {
}
