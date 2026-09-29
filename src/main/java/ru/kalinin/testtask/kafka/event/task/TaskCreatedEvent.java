package ru.kalinin.testtask.kafka.event.task;

import ru.kalinin.testtask.kafka.event.MetaDataEvent;
import ru.kalinin.testtask.kafka.event.enums.EventType;

public record TaskCreatedEvent(
        MetaDataEvent metadata,
        Long taskId,
        String title
) {
    public static TaskCreatedEvent of(Long taskId, String title) {
        return new TaskCreatedEvent(
                MetaDataEvent.of(EventType.TASK_CREATED),
                taskId,
                title
        );
    }
}
