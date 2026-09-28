package ru.kalinin.testtask.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kalinin.testtask.repository.TaskRepository;
import ru.kalinin.testtask.service.interfaces.TaskService;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
}
