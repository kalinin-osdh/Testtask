package ru.kalinin.testtask.dto.response.tasks;

import ru.kalinin.testtask.dto.response.CustomException;

// todo нужна ли эта ошибка - ?
public class ExecutorAlreadyExistsException extends CustomException {
    public ExecutorAlreadyExistsException(Long taskId, Long executorId) {
        super("Для задачи: " + taskId + " уже существует исполнитель: " + executorId);
    }
}
