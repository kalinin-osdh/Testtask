package ru.kalinin.testtask.dto.response.tasks;

import ru.kalinin.testtask.dto.response.NotFoundException;

public class TaskNotFoundException extends NotFoundException {

    public TaskNotFoundException(Long id) {
        super("Задача не найдена: " + id);
    }
}
