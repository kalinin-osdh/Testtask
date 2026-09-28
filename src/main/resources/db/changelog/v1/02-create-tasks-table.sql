CREATE TABLE tasks
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(100) NOT NULL,
    description TEXT         NOT NULL,
    status      VARCHAR(255) NOT NULL,
    executor_id BIGINT,

    CONSTRAINT fk_tasks_executor
        FOREIGN KEY (executor_id)
            REFERENCES users (id)
);