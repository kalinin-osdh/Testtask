package ru.kalinin.testtask.exception;

public record ErrorResponse(
        String error,
        String message
) {
}
