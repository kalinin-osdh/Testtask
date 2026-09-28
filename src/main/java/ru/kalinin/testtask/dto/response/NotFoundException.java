package ru.kalinin.testtask.dto.response;

public class NotFoundException extends CustomException {
    public NotFoundException(String message) {
        super(message);
    }
}
