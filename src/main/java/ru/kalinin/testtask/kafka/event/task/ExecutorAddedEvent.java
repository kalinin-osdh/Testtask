package ru.kalinin.testtask.kafka.event.task;

import ru.kalinin.testtask.kafka.event.MetaDataEvent;
import ru.kalinin.testtask.kafka.event.enums.EventType;

public record ExecutorAddedEvent(
        MetaDataEvent metadata,
        Long taskId,
        Long executorId
) {
    public static ExecutorAddedEvent of(Long taskId, Long executorId) {
        return new ExecutorAddedEvent(
                MetaDataEvent.of(EventType.EXECUTOR_ADDED),
                taskId,
                executorId
        );
    }
}
