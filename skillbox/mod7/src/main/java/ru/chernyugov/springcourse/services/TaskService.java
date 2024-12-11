package ru.chernyugov.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.chernyugov.springcourse.models.Task;
import ru.chernyugov.springcourse.models.User;
import ru.chernyugov.springcourse.repositories.TaskRepository;
import ru.chernyugov.springcourse.repositories.UserRepository;

import java.util.HashSet;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public Flux<Task> findAll() {
        return taskRepository.findAll()
                .flatMap(this::populateTaskWithUsers);
    }

    public Mono<Task> findById(String id) {
        return taskRepository.findById(id)
                .flatMap(this::populateTaskWithUsers);
    }

    public Mono<Task> save(Task task) {
        return taskRepository.save(task);
    }

    public Mono<Task> update(String id, Task task) {
        return taskRepository.findById(id)
                .flatMap(existingTask -> {
                    existingTask.setName(task.getName());
                    existingTask.setDescription(task.getDescription());
                    existingTask.setStatus(task.getStatus());
                    existingTask.setAuthorId(task.getAuthorId());
                    existingTask.setAssigneeId(task.getAssigneeId());
                    existingTask.setObserverIds(task.getObserverIds());
                    return taskRepository.save(existingTask);
                });
    }

    public Mono<Task> addObserver(String taskId, String userId) {
        return taskRepository.findById(taskId)
                .flatMap(task -> {
                    task.getObserverIds().add(userId);
                    return taskRepository.save(task);
                });
    }

    public Mono<Void> deleteById(String id) {
        return taskRepository.deleteById(id);
    }

    private Mono<Task> populateTaskWithUsers(Task task) {
        Mono<User> authorMono = userRepository.findById(task.getAuthorId());
        Mono<User> assigneeMono = userRepository.findById(task.getAssigneeId());
        Flux<User> observersFlux = Flux.fromIterable(task.getObserverIds())
                .flatMap(userRepository::findById);

        return Mono.zip(authorMono, assigneeMono, observersFlux.collectList())
                .map(tuple -> {
                    task.setAuthor(tuple.getT1());
                    task.setAssignee(tuple.getT2());
                    task.setObservers(new HashSet<>(tuple.getT3())); // Преобразование List в Set
                    return task;
                });
    }
}

