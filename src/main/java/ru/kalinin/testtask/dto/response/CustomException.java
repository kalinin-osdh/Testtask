package ru.kalinin.testtask.dto.response;

public abstract class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
