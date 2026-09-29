package ru.kalinin.testtask.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kalinin.testtask.dto.mapper.TaskMapper;
import ru.kalinin.testtask.dto.request.ExecutorRequest;
import ru.kalinin.testtask.dto.request.PageTaskRequest;
import ru.kalinin.testtask.dto.request.StatusRequest;
import ru.kalinin.testtask.dto.request.TaskRequest;
import ru.kalinin.testtask.dto.response.PageResponse;
import ru.kalinin.testtask.dto.response.TaskResponse;
import ru.kalinin.testtask.entity.Task;
import ru.kalinin.testtask.entity.User;
import ru.kalinin.testtask.exception.tasks.TaskNotFoundException;
import ru.kalinin.testtask.exception.users.UserNotFoundException;
import ru.kalinin.testtask.kafka.TaskProducer;
import ru.kalinin.testtask.kafka.event.task.ExecutorAddedEvent;
import ru.kalinin.testtask.kafka.event.task.TaskCreatedEvent;
import ru.kalinin.testtask.repository.TaskRepository;
import ru.kalinin.testtask.repository.UserRepository;
import ru.kalinin.testtask.service.interfaces.TaskService;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    private final TaskProducer taskProducer;

    @Override
    @Transactional(readOnly = true)
    public PageResponse<TaskResponse> getAllTasks(PageTaskRequest request) {
        Sort sort = Sort.by(Sort.Direction.fromString(request.sortDirection()),
                request.sortBy());

        Pageable pageable = PageRequest.of(request.page(), request.size(), sort);

        Page<Task> page = taskRepository.findAll(pageable);

        return taskMapper.toPageResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    public TaskResponse getTaskById(Long id) {
        Task task = getById(id);

        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponse addTask(TaskRequest request) {
        Task saved = taskRepository.save(taskMapper.toEntity(request));

        TaskCreatedEvent event = TaskCreatedEvent.of(saved.getId(), saved.getTitle());

        taskProducer.sendTaskCreated(event);

        return taskMapper.toResponse(saved);
    }

    @Override
    public TaskResponse addExecutor(Long id, ExecutorRequest request) {
        Task task = getById(id);

        User executor = userRepository.findById(request.executorId()).orElseThrow(
                () -> new UserNotFoundException(request.executorId())
        );

        task.setExecutor(executor);

        ExecutorAddedEvent event = ExecutorAddedEvent.of(task.getId(), executor.getId());

        taskProducer.sendExecutorAdded(event);

        return taskMapper.toResponse(taskRepository.save(task));
    }

    @Override
    public TaskResponse changeStatus(Long id, StatusRequest request) {
        Task task = getById(id);

        task.setStatus(request.status());

        return taskMapper.toResponse(taskRepository.save(task));
    }

    @Override
    @Transactional(readOnly = true)
    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException(id)
        );
    }
}
