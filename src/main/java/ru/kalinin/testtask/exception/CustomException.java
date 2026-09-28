package ru.kalinin.testtask.exception;

public abstract class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
