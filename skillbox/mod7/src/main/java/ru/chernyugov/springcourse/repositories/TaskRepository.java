package ru.chernyugov.springcourse.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.chernyugov.springcourse.models.Task;

public interface TaskRepository extends ReactiveMongoRepository<Task, String> {
}
