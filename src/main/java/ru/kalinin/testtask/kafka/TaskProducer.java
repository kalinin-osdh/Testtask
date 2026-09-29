package ru.kalinin.testtask.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.kalinin.testtask.kafka.event.task.ExecutorAddedEvent;
import ru.kalinin.testtask.kafka.event.task.TaskCreatedEvent;

@Service
@RequiredArgsConstructor
public class TaskProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendTaskCreated(TaskCreatedEvent event) {
        kafkaTemplate.send(KafkaTopics.TASK_CREATED, event);
    }

    public void sendExecutorAdded(ExecutorAddedEvent event) {
        kafkaTemplate.send(KafkaTopics.EXECUTOR_ADDED, event);
    }

}


