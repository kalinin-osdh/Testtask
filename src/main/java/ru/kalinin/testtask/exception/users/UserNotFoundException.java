package ru.kalinin.testtask.exception.users;

import ru.kalinin.testtask.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super("Пользователь не найден: " + id);
    }
}
