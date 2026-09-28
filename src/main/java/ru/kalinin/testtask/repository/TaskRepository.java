package ru.kalinin.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kalinin.testtask.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
