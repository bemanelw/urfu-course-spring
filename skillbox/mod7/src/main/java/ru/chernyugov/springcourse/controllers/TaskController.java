package ru.chernyugov.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.chernyugov.springcourse.dto.TaskDto;
import ru.chernyugov.springcourse.mappers.TaskMapper;
import ru.chernyugov.springcourse.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;

    @GetMapping
    public Flux<TaskDto> getAllTasks() {
        return taskService.findAll()
                .map(taskMapper::toTaskDto);
    }

    @GetMapping("/{id}")
    public Mono<TaskDto> getTaskById(@PathVariable String id) {
        return taskService.findById(id)
                .map(taskMapper::toTaskDto);
    }

    @PostMapping
    public Mono<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        return taskService.save(taskMapper.toTask(taskDto))
                .map(taskMapper::toTaskDto);
    }

    @PutMapping("/{id}")
    public Mono<TaskDto> updateTask(@PathVariable String id, @RequestBody TaskDto taskDto) {
        return taskService.update(id, taskMapper.toTask(taskDto))
                .map(taskMapper::toTaskDto);
    }

    @PostMapping("/{taskId}/observers/{userId}")
    public Mono<TaskDto> addObserver(@PathVariable String taskId, @PathVariable String userId) {
        return taskService.addObserver(taskId, userId)
                .map(taskMapper::toTaskDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTask(@PathVariable String id) {
        return taskService.deleteById(id);
    }
}