package ru.kalinin.testtask.exception.tasks;

import ru.kalinin.testtask.exception.NotFoundException;

public class TaskNotFoundException extends NotFoundException {

    public TaskNotFoundException(Long id) {
        super("Задача не найдена: " + id);
    }
}
