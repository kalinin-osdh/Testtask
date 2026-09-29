package ru.kalinin.testtask.kafka.event;

import ru.kalinin.testtask.kafka.event.enums.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

public record MetaDataEvent(
        UUID eventId,
        EventType eventType,
        LocalDateTime createdAt
) {
    public static MetaDataEvent of(EventType eventType) {
        return new MetaDataEvent(
                UUID.randomUUID(),
                eventType,
                LocalDateTime.now()
        );
    }
}
