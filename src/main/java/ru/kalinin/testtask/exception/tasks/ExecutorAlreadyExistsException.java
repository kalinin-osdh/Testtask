package ru.kalinin.testtask.exception.tasks;

import ru.kalinin.testtask.exception.CustomException;

// todo нужна ли эта ошибка - ?
public class ExecutorAlreadyExistsException extends CustomException {
    public ExecutorAlreadyExistsException(Long taskId, Long executorId) {
        super("Для задачи: " + taskId + " уже существует исполнитель: " + executorId);
    }
}
